package org.ibs.service.dto.mapper;

import org.ibs.service.dto.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {

    Employee toDto(org.ibs.service.domain.entity.Employee employee);
}
