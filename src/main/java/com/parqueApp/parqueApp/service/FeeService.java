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
import com.parqueApp.parqueApp.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Service
public class FeeService {
    @Autowired
    private FeeRepository feeRepository;

    public void createFee(long id_vehicle, String type_vehicle) {
        BigDecimal value = type_vehicle.equalsIgnoreCase("moto") ? BigDecimal.valueOf(2000) : BigDecimal.valueOf(4000);
        feeRepository.createFee(value, id_vehicle);
    }

    public Fee getLastFee() {
        return feeRepository.getLastFee();
    }

    public Fee getFeeByParkingSpaceId(long parking_space_id) {
        return feeRepository.getFeeByParkingSpaceId(parking_space_id);
    }

    public Fee getFeeById(long id) {
        return feeRepository.getFeeById(id);
    }
}