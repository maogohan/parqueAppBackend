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

/**
 * The class represents the fee entity.
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "fee")
public class Fee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FeeId")
    @SequenceGenerator(name = "FeeId", sequenceName = "FEE_SEQ")
    private long id;
    @Column(columnDefinition = "NUMERIC(10,2)")
    private BigDecimal value;
    @OneToOne
    @JoinColumn(name = "vehicle")
    private Vehicle vehicle;

    public Fee(BigDecimal value, Vehicle vehicle) {
        this.value = value;
        this.vehicle = vehicle;
    }
}