package edu.cursor.spring_data_lesson.controller;

import edu.cursor.spring_data_lesson.model.Employee;
import edu.cursor.spring_data_lesson.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addUser(@RequestBody Employee user) {
        employeeService.save(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAllUsers() {
        List<Employee> all = employeeService.findAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
//        userRepository.updateUserById(id, user);
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body("User " + user.toString() + " was updated successfully");
//    }
//
//
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity deleteUser(@PathVariable Long id) {
//        userRepository.removeUserById(id);
//        return ResponseEntity
//                .status(HttpStatus.NO_CONTENT)
//                .body("User by id" + id + "was deleted successfully");
//    }

}
