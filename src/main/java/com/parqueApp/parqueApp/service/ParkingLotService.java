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

import com.parqueApp.parqueApp.model.ParkingLot;
import com.parqueApp.parqueApp.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@Service
public class ParkingLotService implements ParkingLotRepository {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }

    @Override
    public List<ParkingLot> findAllById(Iterable<Long> longs) {
        return parkingLotRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        parkingLotRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        parkingLotRepository.deleteAll();
    }

    @Override
    public void flush() { }

    @Override
    public <S extends ParkingLot> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ParkingLot> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ParkingLot> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ParkingLot getOne(Long aLong) {
        return null;
    }

    @Override
    public ParkingLot getById(Long aLong) {
        return null;
    }

    @Override
    public ParkingLot getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ParkingLot> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ParkingLot> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ParkingLot> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ParkingLot> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ParkingLot> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ParkingLot> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ParkingLot, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ParkingLot> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ParkingLot> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ParkingLot> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }



    @Override
    public void delete(ParkingLot entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ParkingLot> entities) {

    }

    @Override
    public List<ParkingLot> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ParkingLot> findAll(Pageable pageable) {
        return null;
    }
}