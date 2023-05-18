package com.parqueApp.parqueApp.rest;

import com.parqueApp.parqueApp.model.Fee;
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

public interface FeeRestOpenApi {

    @Operation(summary = "Get all fees", description = "Detailed fee list", tags = {"fee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = Fee.class))))
    })
    @RequestMapping(method = RequestMethod.GET, value = "getAllFees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fee> getAllFees();

    @Operation(summary = "Get fee by parking space id", description = "Detailed fee", tags = {"fee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Fee.class))),
            @ApiResponse(responseCode = RestApiConstants.BAD_REQUEST_CODE, description = RestApiConstants.BAD_REQUEST, content = @Content),
            @ApiResponse(responseCode = RestApiConstants.NOT_FOUND_CODE, description = RestApiConstants.NOT_FOUND, content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET, value = "getFeeByParkingSpaceId/{parking_space_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Fee getFeeByParkingSpaceId(
            @NotNull @Parameter(in = ParameterIn.PATH, description = "Parking space id.", required = true, schema = @Schema(implementation = long.class))
            @Valid @PathVariable(value = RestApiConstants.PARKING_SPACE_ID, required = true) long parking_space_id);

    @Operation(summary = "Get fee by parking space type", description = "Detailed fee", tags = {"fee"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = double.class))),
            @ApiResponse(responseCode = RestApiConstants.BAD_REQUEST_CODE, description = RestApiConstants.BAD_REQUEST, content = @Content),
            @ApiResponse(responseCode = RestApiConstants.NOT_FOUND_CODE, description = RestApiConstants.NOT_FOUND, content = @Content)
    })
    @RequestMapping(method = RequestMethod.GET, value = "getFeeValueByParkingSpaceTypeAndParkingLotId/{parking_space_type}/{parking_lot_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double getFeeValueByParkingSpaceTypeAndParkingLotId(
            @NotNull @Parameter(in = ParameterIn.PATH, description = "Parking space type.", required = true, schema = @Schema(implementation = String.class))
            @Valid @PathVariable(value = RestApiConstants.PARKING_SPACE_TYPE, required = true) String parking_space_type,
            @NotNull @Parameter(in = ParameterIn.PATH, description = "Parking lot id.", required = true, schema = @Schema(implementation = long.class))
            @Valid @PathVariable(value = RestApiConstants.PARKING_LOT_ID, required = true) long parking_lot_id);
}