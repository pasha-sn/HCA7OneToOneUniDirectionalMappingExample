package com.hibernateinfo.client;

import java.util.Date;

import com.hibernateinfo.entities.Address;
import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.service.EmployeeService;
import com.hibernateinfo.service.impl.EmployeeServiceImpl;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest1SaveEmployeeWithAddress {

	public static void main(String[] args) 
	{
		EmployeeService employeeService = new EmployeeServiceImpl();
		createEmployee(employeeService);		
		
	}	
	
	private static void createEmployee(EmployeeService employeeService) {
		employeeService.createEmployee(getEmployee());
	}
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Pasha Sadi");
		employee.setEmail("pasha.sn@gmail.com");
		employee.setSalary(65000.00);
		employee.setDoj(new Date());
		
		Address address = new Address();
		address.setStreet("Peel St");
		address.setCity("Montreal");
		address.setState("Quebec");
		address.setPostalcode(19317l);
		
		employee.setAddress(address);		
		
		return employee;
	}	
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
Hibernate: 
    
    create table address_table (
       address_id number(10,0) not null,
        city_name varchar2(50 char),
        postal_code number(19,0),
        state_name varchar2(255 char),
        street_name varchar2(50 char),
        primary key (address_id)
    )
Hibernate: 
    
    create table employee_table (
       employee_id number(10,0) not null,
        date_of_join timestamp,
        email varchar2(255 char),
        employee_name varchar2(100 char) not null,
        salary double precision,
        address_id number(10,0),
        primary key (employee_id)
    )
Hibernate: 
    
    alter table employee_table 
       drop constraint UK_2casspobvavvi9s23312f9mhm
Hibernate: 
    
    alter table employee_table 
       add constraint UK_2casspobvavvi9s23312f9mhm unique (email)
Hibernate: 
    
    alter table employee_table 
       add constraint FK4nfdimis4bkn38mvl2btm69p2 
       foreign key (address_id) 
       references address_table
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Hibernate: 
    select
        hibernate_sequence.nextval 
    from
        dual
Employee is created with Id:: 8
Hibernate: 
    insert 
    into
        address_table
        (city_name, postal_code, state_name, street_name, address_id) 
    values
        (?, ?, ?, ?, ?)
Hibernate: 
    insert 
    into
        employee_table
        (address_id, date_of_join, email, employee_name, salary, employee_id) 
    values
        (?, ?, ?, ?, ?, ?)
*/