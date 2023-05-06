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

import com.parqueApp.parqueApp.model.ParkingSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpace, Long> {

    @Query(value = "SELECT ps FROM ParkingSpace ps")
    List<ParkingSpace> getAllParkingSpaces();

    @Query(value = "SELECT ps FROM ParkingSpace ps WHERE ps.parking_lot.id = :parking_lot_id")
    List<ParkingSpace> getAllParkingSpacesByParkingLotId(@Param("parking_lot_id") long parking_lot_id);

    @Query(value = "SELECT ps FROM ParkingSpace ps WHERE ps.parking_lot.id = :parking_lot_id AND ps.state = 0")
    List<ParkingSpace> getAllParkingSpacesEnableByParkingLotId(@Param("parking_lot_id") long parking_lot_id);

    @Query(value = "SELECT ps FROM ParkingSpace ps WHERE ps.id = :id")
    ParkingSpace getParkingSpaceById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE parking_space SET state = 1 WHERE id = :id", nativeQuery = true)
    void changeParkingSpaceStateToReserved(@Param("id") long id);

    @Query(value = "SELECT ps FROM ParkingSpace ps WHERE ps.type = :type")
    ParkingSpace getParkingSpaceByType(@Param("type") int type);
}