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

import com.parqueApp.parqueApp.model.Vehicle;
import com.parqueApp.parqueApp.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@RestController
@RequestMapping("/vehicle/")
public class VehicleRest {
    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping(method = RequestMethod.GET, value = "getAllVehicles", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Vehicle> getAllServices()
    {
        return vehicleRepository.getAllVehicles();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllServicesByParkingLotId/{parking_lot_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Vehicle> getAllServicesByParkingLotId(@PathVariable("parking_lot_id") long parking_lot_id)
    {
        return vehicleRepository.getAllVehiclesByParkingLotId(parking_lot_id);
    }
}