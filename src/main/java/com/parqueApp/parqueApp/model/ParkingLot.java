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
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * The class represents the parking lot entity.
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "parking_lot")
public class ParkingLot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParkingLotId")
    @SequenceGenerator(name = "ParkingLotId", sequenceName = "PARKING_LOT_SEQ")
    private long id;
    private String name;
    private LocalTime start_date;
    private LocalTime end_date;
    private String address;
    @Column(columnDefinition = "NUMERIC(10,8)")
    private BigDecimal altitude;
    @Column(columnDefinition = "NUMERIC(10,8)")
    private BigDecimal longitude;

    public ParkingLot(String name, LocalTime start_date, LocalTime end_date, String address, BigDecimal altitude, BigDecimal longitude) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.address = address;
        this.altitude = altitude;
        this.longitude = longitude;
    }
}