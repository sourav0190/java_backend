package com.example.ems_backend.Mapper;


import com.example.ems_backend.Dto.EmployeeDto;
import com.example.ems_backend.Entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

    @Mapping(target = "id", ignore = true)
    void updateEmployeeFromDto(EmployeeDto dto, @MappingTarget Employee entity);
}