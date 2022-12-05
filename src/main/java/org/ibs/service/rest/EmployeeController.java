package org.ibs.service.rest;


import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domain.EmployeeRepository;
import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/employees")
@Slf4j

public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    Iterable<Employee> getAll() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee newEmployee(@RequestBody Employee employee) {
        log.info("---------------------------------------------");
        if (employee.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Found Id. Use PUT instead of POST.");
        }
        return repository.save(employee);
    }

    @GetMapping("/{id}")
    Employee getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
