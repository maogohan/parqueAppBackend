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
package com.parqueApp.parqueApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * The class represents the ticket entity.
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TicketId")
    @SequenceGenerator(name = "TicketId", sequenceName = "TICKET_SEQ")
    private long id;
    private LocalDate date;
    private LocalTime start_time;
    private LocalTime end_time;
    @OneToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle vehicle;

    public Ticket(LocalDate date, LocalTime start_time, LocalTime end_time, Vehicle vehicle) {
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.vehicle = vehicle;
    }
}