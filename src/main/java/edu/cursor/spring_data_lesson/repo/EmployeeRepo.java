package edu.cursor.spring_data_lesson.repo;

import edu.cursor.spring_data_lesson.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Stream<Employee> findByFirstNameAndLastName(String fName,String lName);

    List<Employee> findFirst5ByFirstNameStartingWithOrderByFirstName(String s);

    @Query(value = "select * from employees where salary = (select max(salary) from employees)",nativeQuery = true)
    Optional<Employee> findByMaXSalary();


}
