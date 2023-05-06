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
package com.parqueApp.parqueApp.service;

import com.parqueApp.parqueApp.model.Fee;
import com.parqueApp.parqueApp.repository.ParkingSpaceRepository;
import com.parqueApp.parqueApp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private FeeService feeService;

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    public void createTicket(LocalTime end_time, LocalTime start_time, long id_vehicle, long id_fee) {
        Duration duration = Duration.between(start_time, end_time);
        long diffInHours = duration.toHours();

        Fee fee = feeService.getFeeById(id_fee);
        BigDecimal pay = fee != null && fee.getValue() != null ?
                fee.getValue().multiply(BigDecimal.valueOf(Double.valueOf(diffInHours)))
                : BigDecimal.valueOf(0);

        ticketRepository.createTicket(
                LocalDate.now(),
                end_time,
                start_time,
                id_vehicle,
                0,
                pay
                );
    }
}