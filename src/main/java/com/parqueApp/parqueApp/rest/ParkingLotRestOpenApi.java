package com.parqueApp.parqueApp.rest;

import com.parqueApp.parqueApp.model.ParkingLot;
import com.parqueApp.parqueApp.noEntity.ParkingLotFilter;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/parking-lot/")
public interface ParkingLotRestOpenApi {

    @Operation(summary = "Get all parking lots", description = "Detailed parking lots list", tags = {"parking-lot"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ParkingLot.class))))
    })
    @RequestMapping(method = RequestMethod.GET, value = "getAllParkingLots", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingLot> getAllParkingLot();

    @Operation(summary = "Get parking lots by parking space type", description = "Detailed parking lots list", tags = {"parking-lot"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ParkingLot.class))))
    })
    @RequestMapping(method = RequestMethod.GET, value = "getParkingLotsByParkingSpaceType/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingLot> getParkingLotsByParkingSpaceType(
            @NotNull @Parameter(in = ParameterIn.PATH, description = "Parking space type.", required = true, schema = @Schema(implementation = String.class))
            @Valid @PathVariable(value = RestApiConstants.TYPE, required = true) String type);

    @Operation(summary = "Get parking lots filtering by the optional parameters minimum amount, maximum amount, start time, end time, with a mandatory vehicle type.",
            description = "Detailed parking lots list", tags = {"parking-lot"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = RestApiConstants.SUCCESSFUL_OPERATION_CODE, description = RestApiConstants.SUCCESSFUL_OPERATION,
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ParkingLot.class))))
    })
    @RequestMapping(method = RequestMethod.POST, value = "getParkingLotsWithFilters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingLot> getParkingLotsWithFilters(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "ParkingLotFilter that contains the optional parameters minimum amount, maximum amount, start time, end time, with a mandatory vehicle type.",
                    required = true,
            content = @Content(schema=@Schema(implementation = ParkingLotFilter.class)))
            @RequestBody ParkingLotFilter parkingLotFilter);
}