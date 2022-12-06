package org.ibs.service.bussines;

import org.ibs.service.domain.DepartmentRepository;
import org.ibs.service.domain.entity.Department;
import org.ibs.service.domain.entity.Employee;
import org.ibs.service.dto.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalaryService {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeMapper mapper;

    public Optional<org.ibs.service.dto.Employee> maxSalaryEmployeeIdDepartment(Long departmentId) {
        Optional<Department> departmentOpt = repository.findById(departmentId);
        if (departmentOpt.isEmpty() || departmentOpt.get().getEmployees().isEmpty()) {
            return Optional.empty();
        }

        Employee employee = departmentOpt.get().getEmployees().stream()
                .max((e1, e2) -> e1.getMonthSalary().compareTo(e2.getMonthSalary())).get();

        return Optional.of(mapper.toDto(employee));
    }
}