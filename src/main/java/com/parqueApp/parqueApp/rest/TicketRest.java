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

import com.parqueApp.parqueApp.model.Ticket;
import com.parqueApp.parqueApp.repository.TicketRepository;
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
@RequestMapping("/ticket/")
public class TicketRest {
    @Autowired
    private TicketRepository ticketRepository;

    @RequestMapping(method = RequestMethod.GET, value = "getAllTickets", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Ticket> getAllTickets()
    {
        return ticketRepository.getAllTickets();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllTicketsByVehicletId/{vehicle_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Ticket> getAllTicketsByVehicletId(@PathVariable("vehicle_id") long vehicle_id)
    {
        return ticketRepository.getAllTicketsByVehicleId(vehicle_id);
    }
}