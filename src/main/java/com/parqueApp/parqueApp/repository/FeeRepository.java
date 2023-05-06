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

import com.parqueApp.parqueApp.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
    @Query(value = "SELECT f FROM Fee f")
    List<Fee> getAllFees();

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO FEE(id, value, id_vehicle) VALUES (NEXTVAL('FEE_SEQ'), :value, :id_vehicle)", nativeQuery = true)
    void createFee(@Param("value") BigDecimal value, @Param("id_vehicle") long id_vehicle);

    @Query(value = "SELECT * FROM Fee ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Fee getLastFee();

    @Query(value = "SELECT f FROM Fee f WHERE f.parking_space.id = :parking_space_id")
    Fee getFeeByParkingSpaceId(@Param("parking_space_id") long parking_space_id);

    @Query(value = "SELECT f FROM Fee f WHERE f.id = :id")
    Fee getFeeById(@Param("id") long id);
}