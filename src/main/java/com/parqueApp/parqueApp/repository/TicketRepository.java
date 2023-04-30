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
package com.parqueApp.parqueApp.repository;

import com.parqueApp.parqueApp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT t FROM Ticket t")
    List<Ticket> getAllTickets();

    @Query(value = "SELECT t FROM Ticket t WHERE t.vehicle.id = :vehicle_id")
    List<Ticket> getAllTicketsByVehicleId(@Param("vehicle_id") long vehicle_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ticket(id, date, end_time, start_time, id_vehicle, state, pay)" +
            " VALUES (NEXTVAL('TICKET_SEQ'), :date, :end_time, :start_time, :id_vehicle, :state, :pay)", nativeQuery = true)
    void createTicket(@Param("date") LocalDate date,
                   @Param("end_time") LocalTime end_time,
                   @Param("start_time") LocalTime start_time,
                   @Param("id_vehicle") long id_vehicle,
                   @Param("state") int state,
                   @Param("pay") BigDecimal pay);
}