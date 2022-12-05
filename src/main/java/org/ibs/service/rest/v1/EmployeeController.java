package org.ibs.service.rest.v1;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.ibs.service.domain.EmployeeRepository;
import org.ibs.service.domain.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController("employee controller v1")
@RequestMapping("/v1/employees")
@Slf4j

public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    Iterable<Employee> getAll(@RequestParam(required = false) String firstName) {
            if (firstName == null) {
                return repository.findAll();
            }
            return repository.findAllByFirstName(firstName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(operationId = "addEmp", summary = "Adds new employee.")
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
