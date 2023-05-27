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

import com.parqueApp.parqueApp.model.ParkingLot;
import com.parqueApp.parqueApp.noEntity.ParkingLotFilter;
import com.parqueApp.parqueApp.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@RestController
@RequestMapping("/parking-lot/")
public class ParkingLotRest implements ParkingLotRestOpenApi{
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @RequestMapping(method = RequestMethod.GET, value = "getAllParkingLots", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingLot> getAllParkingLot()
    {
        return parkingLotRepository.getAllParkingLots();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getParkingLotsByParkingSpaceType/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingLot> getParkingLotsByParkingSpaceType(@PathVariable("type") String type)
    {
        return parkingLotRepository.getParkingLotsByParkingSpaceType(type);
    }

    @RequestMapping(method = RequestMethod.POST, value = "getParkingLotsWithFilters", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkingLot> getParkingLotsWithFilters(@RequestBody ParkingLotFilter parkingLotFilter)
    {
        return parkingLotRepository.getParkingLotsWithFilters(
                parkingLotFilter.getMin_amount(),
                parkingLotFilter.getMax_amount(),
                parkingLotFilter.getStart_time(),
                parkingLotFilter.getEnd_time(),
                parkingLotFilter.getType()
        );
    }
}