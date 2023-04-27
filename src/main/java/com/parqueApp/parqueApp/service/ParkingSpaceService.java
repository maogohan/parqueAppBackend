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

import com.parqueApp.parqueApp.model.ParkingSpace;
import com.parqueApp.parqueApp.repository.ParkingSpaceRepository;
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
public class ParkingSpaceService implements ParkingSpaceRepository {

    @Autowired
    private ParkingSpaceRepository parkingSpaceRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends ParkingSpace> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ParkingSpace> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ParkingSpace getOne(Long aLong) {
        return null;
    }

    @Override
    public ParkingSpace getById(Long aLong) {
        return null;
    }

    @Override
    public ParkingSpace getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ParkingSpace> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ParkingSpace> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ParkingSpace, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> S save(S entity) {
        return null;
    }

    @Override
    public <S extends ParkingSpace> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ParkingSpace> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<ParkingSpace> findAll() {
        return null;
    }

    @Override
    public List<ParkingSpace> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ParkingSpace entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends ParkingSpace> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ParkingSpace> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ParkingSpace> findAll(Pageable pageable) {
        return null;
    }
}