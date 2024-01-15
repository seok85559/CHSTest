package com.employee.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDTO;
import com.employee.mapper.EmployeeMapper;

@Service
public class EmployeeService {
	private EmployeeMapper mapper;
	
	public EmployeeService(EmployeeMapper employeeMapper) {
		this.mapper = employeeMapper;
	}

	public List<EmployeeDTO> selectAllEmployee() {		
		return mapper.selectAllEmployee();
	}
	public void deleteEmployee(String eno) {
		mapper.deleteEmployee(eno);		
	}
	public EmployeeDTO login(String eno, String name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("eno", eno);
		map.put("name", name);
		
		return mapper.login(map);
	}
	
	
}
