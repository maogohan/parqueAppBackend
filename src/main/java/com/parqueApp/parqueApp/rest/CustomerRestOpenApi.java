package com.parqueApp.parqueApp.rest;

import com.parqueApp.parqueApp.model.Customer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/customer/")
public interface CustomerRestOpenApi {

    @Operation(summary = "Get all customers", description = "Detailed customer list", tags = {"customer"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Customer.class))))
    })
    @RequestMapping(method = RequestMethod.GET, value = "getAllCustomers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers();
}