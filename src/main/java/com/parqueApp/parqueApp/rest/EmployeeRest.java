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
package com.parqueApp.parqueApp.rest;

import com.parqueApp.parqueApp.model.Employee;
import com.parqueApp.parqueApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yon Mauricio Ruiz Beltrán {@literal <ymruiz@estudiante.uniajc.edu.co>}
 */
@RestController
@RequestMapping("/employee/")
public class EmployeeRest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(method = RequestMethod.GET, value = "getAllEmployees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.getAllEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAllEmployeesByParkingLotId/{parking_lot_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployeesByParkingLotId(@PathVariable("parking_lot_id") long parking_lot_id)
    {
        return employeeRepository.getAllEmployeesByParkingLotId(parking_lot_id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getEmployeeById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById(@PathVariable("id") long id)
    {
        return employeeRepository.getEmployeeById(id);
    }
}