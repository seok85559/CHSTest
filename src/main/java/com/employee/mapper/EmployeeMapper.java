package com.employee.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.employee.dto.EmployeeDTO;

@Mapper
public interface EmployeeMapper {


	List<EmployeeDTO> selectAllEmployee();
	void deleteEmployee(String eno);
	EmployeeDTO login(HashMap<String, Object> map);
}
