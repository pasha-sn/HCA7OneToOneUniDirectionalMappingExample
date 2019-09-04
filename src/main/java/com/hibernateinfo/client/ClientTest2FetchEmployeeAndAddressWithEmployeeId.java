package com.hibernateinfo.client;

import org.hibernate.Session;

import com.hibernateinfo.entities.Employee;
import com.hibernateinfo.util.HibernateUtil;

/**
 * @author Pasha
 * Remember the golden rule: readable code is often faster code. 
 * Produce readable code first and only change it if it proves to be too slow.
 */
public class ClientTest2FetchEmployeeAndAddressWithEmployeeId {

	public static void main(String[] args) 
	{
		Employee employee = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			employee = session.get(Employee.class, 10);
			System.out.println(employee);
			System.out.println(employee.getAddress());
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
/*
<property name="hibernate.hbm2ddl.auto">update</property>
Hibernate: 
    select
        employee0_.employee_id as employee_id1_1_0_,
        employee0_.address_id as address_id6_1_0_,
        employee0_.date_of_join as date_of_join2_1_0_,
        employee0_.email as email3_1_0_,
        employee0_.employee_name as employee_name4_1_0_,
        employee0_.salary as salary5_1_0_,
        address1_.address_id as address_id1_0_1_,
        address1_.city_name as city_name2_0_1_,
        address1_.postal_code as postal_code3_0_1_,
        address1_.state_name as state_name4_0_1_,
        address1_.street_name as street_name5_0_1_ 
    from
        employee_table employee0_ 
    left outer join
        address_table address1_ 
            on employee0_.address_id=address1_.address_id 
    where
        employee0_.employee_id=?
Employee [employeeId=10, employeeName=Pasha Sadi, email=pasha.sn@gmail.com, doj=2019-08-01 09:00:00.000, address=Address [street=Peel St, city=Montreal, state=Quebec, postalcode=19317], salary=65000.0]
Address [street=Peel St, city=Montreal, state=Quebec, postalcode=19317]
*/