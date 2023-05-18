package com.parqueApp.parqueApp.rest;

import com.parqueApp.parqueApp.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/customer/")
public interface CustomerRestOpenApi {

    @Operation(summary = "Get all customers", description = "Detailed customer list", tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Customer.class))))
    })
    @RequestMapping(method = RequestMethod.GET, value = "getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers();

    @Operation(summary = "Get customer by provided id", description = "Detailed customer", tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Customer.class))),
            @ApiResponse(responseCode = RestApiConstants.BAD_REQUEST_CODE, description = RestApiConstants.BAD_REQUEST, content = @Content),
            @ApiResponse(responseCode = RestApiConstants.NOT_FOUND_CODE, description = RestApiConstants.NOT_FOUND, content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET, value = "getCustomerById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Customer getCustomerById(
            @NotNull @Parameter(in = ParameterIn.PATH, description = "Customer id.", required = true, schema = @Schema(implementation = long.class))
            @Valid @PathVariable(value = RestApiConstants.ID, required = true) long id
    );
}