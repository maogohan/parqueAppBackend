/*
 *  Copyright 2023
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       https://apache.org/licenses/LICENSE-2.0.txt
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.parqueApp.parqueApp.rest;

import com.parqueApp.parqueApp.model.ParkingSpace;
import com.parqueApp.parqueApp.repository.ParkingSpaceRepository;
import com.parqueApp.parqueApp.service.FeeService;
import com.parqueApp.parqueApp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@RestController
@RequestMapping("/parking-space/")
public class ParkingSpaceRest {
    /**
     * Reference to ParkingSpaceRepository
     */
    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    /**
     * Reference to FeeService
     */
    @Autowired
    private FeeService feeService;

    /***
     * Reference to TicketService
     */
    @Autowired
    private TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET, value = "getAllParkingSpaces", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<ParkingSpace> getAllParkingSpaces()
    {
        return parkingSpaceRepository.getAllParkingSpaces();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllParkingSpacesByParkingLotId/{parking_lot_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<ParkingSpace> getAllParkingSpacesByParkingLotId(@PathVariable("parking_lot_id") long parking_lot_id)
    {
        return parkingSpaceRepository.getAllParkingSpacesByParkingLotId(parking_lot_id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllParkingSpacesEnableByParkingLotId/{parking_lot_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<ParkingSpace> getAllParkingSpacesEnableByParkingLotId(@PathVariable("parking_lot_id") long parking_lot_id)
    {
        return parkingSpaceRepository.getAllParkingSpacesEnableByParkingLotId(parking_lot_id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            value = "reserveParkingSpace/{id_parking_space}/{id_vehicle}/{type_vehicle}/{start_time}/{end_time}")
    private void reserveParkingSpace(
            @PathVariable("id_parking_space") long id_parking_space,
            @PathVariable("id_vehicle") long id_vehicle,
            @PathVariable("start_time") LocalTime start_time,
            @PathVariable("end_time") LocalTime end_time)
    {
        parkingSpaceRepository.changeParkingSpaceStateToReserved(id_parking_space);
        ticketService.createTicket(end_time, start_time, id_vehicle, id_parking_space);
    }
}