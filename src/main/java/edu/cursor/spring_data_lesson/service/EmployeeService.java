package edu.cursor.spring_data_lesson.service;

import edu.cursor.spring_data_lesson.model.Employee;
import edu.cursor.spring_data_lesson.repo.EmployeeRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
//@Bean
public class EmployeeService {

    private final EmployeeRepo employeeRepository;

    public EmployeeService(EmployeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }


    public void removeEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
//
    public Stream<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName,lastName);
    }


}
