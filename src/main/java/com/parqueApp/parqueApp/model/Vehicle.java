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

/**
 * The class represents the vehicle entity.
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VehicleId")
    @SequenceGenerator(name = "VehicleId", sequenceName = "VEHICLE_SEQ")
    private long id;
    private String plate;
    private String type;
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;
    @OneToOne
    @JoinColumn(name = "id_parking_space")
    private ParkingSpace parking_space;

    public Vehicle(String plate, String type, Employee employee, Customer customer, ParkingSpace parkingSpace) {
        this.plate = plate;
        this.type = type;
        this.employee = employee;
        this.customer = customer;
        this.parking_space = parkingSpace;
    }
}