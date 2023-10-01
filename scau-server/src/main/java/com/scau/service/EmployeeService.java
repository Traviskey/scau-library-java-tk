package com.scau.service;

import com.scau.dto.EmployeeLoginDTO;
import com.scau.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

}
