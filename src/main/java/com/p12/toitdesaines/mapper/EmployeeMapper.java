package com.p12.toitdesaines.mapper;

import com.p12.toitdesaines.DTO.EmployeeDTO;
import com.p12.toitdesaines.entity.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    EmployeeDTO toEmployee (Employee entity);

    Employee toDto(EmployeeDTO dto);

}

