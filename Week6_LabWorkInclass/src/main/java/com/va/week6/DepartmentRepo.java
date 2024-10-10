package com.va.week6;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

//public interface DepartmentRepo extends CrudRepository<Department, Integer>
public interface DepartmentRepo extends JpaRepository<Department, Integer>
{

}
