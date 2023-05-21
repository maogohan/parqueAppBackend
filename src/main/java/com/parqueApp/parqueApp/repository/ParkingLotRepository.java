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

import com.parqueApp.parqueApp.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

    @Query(value = "SELECT pl FROM ParkingLot pl")
    List<ParkingLot> getAllParkingLots();

    @Query(value = "SELECT pl FROM ParkingLot pl WHERE pl.id = :id")
    ParkingLot getParkingLotById(@Param("id") long id);

    @Query(value = "SELECT pl FROM ParkingLot pl WHERE pl.id IN( SELECT ps.parking_lot FROM ParkingSpace ps WHERE ps.type= :type)")
    List<ParkingLot> getParkingLotsByParkingSpaceType(@Param("type") String type);

    @Query(value = "SELECT DISTINCT pl \n" +
            "FROM ParkingLot pl \n" +
            "JOIN ParkingSpace ps \n" +
            "ON pl.id = ps.parking_lot.id \n" +
            "JOIN Fee f \n" +
            "ON ps.id = f.parking_space.id \n" +
            "WHERE pl.start_date >= coalesce(:start_time, pl.start_date) \n" +
            "AND pl.end_date <= coalesce(:end_time, pl.end_date) \n" +
            "AND f.value >= coalesce(:min_amount, f.value) \n" +
            "AND f.value <= coalesce(:max_amount, f.value) \n" +
            "AND ps.type = :type")
    List<ParkingLot> getParkingLotsWithFilters(@Param("min_amount") double min_amount,
                                               @Param("max_amount") double max_amount,
                                               @Param("start_time") LocalTime start_time,
                                               @Param("end_time") LocalTime end_time,
                                               @Param("type") String type);
}