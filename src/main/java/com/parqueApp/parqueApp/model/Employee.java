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
 * The class represents the employee lot entity.
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EmployeeId")
    @SequenceGenerator(name = "EmployeeId", sequenceName = "EMPLOYEE_SEQ")
    private long id;
    private String employment;
    int id_card;
    private String first_name;
    private String last_name;
    private int phone;
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_parking_lot")
    private ParkingLot parking_lot;

    public Employee(String employment, int id_card, String first_name, String last_name, int phone, String address, ParkingLot parking_lot) {
        this.employment = employment;
        this.id_card = id_card;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.address = address;
        this.parking_lot = parking_lot;
    }
}