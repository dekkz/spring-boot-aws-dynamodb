package br.com.dkzit.project.controllers;

import br.com.dkzit.project.documents.EmployeeDocument;
import br.com.dkzit.project.exceptions.DataNotFoundException;
import br.com.dkzit.project.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDocument>> getAll() {
        log.info("EmployeeController.getAll - start - getting all employees");
        List<EmployeeDocument> response = employeeService.getAll();
        log.info("EmployeeController.getAll - end");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDocument> getEmployeeById(@PathVariable(value = "id") String id) {
        log.info("EmployeeController.getEmployeeById - start - getting employee with id: {}", id);
        EmployeeDocument response = employeeService.getById(id).orElseThrow(() -> new DataNotFoundException("Not found"));
        log.info("EmployeeController.getEmployeeById - end - get employee with id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDocument> save(@RequestBody EmployeeDocument employeeDocument) {
        log.info("EmployeeController.save - start - saving employee");
        EmployeeDocument response = employeeService.save(employeeDocument);
        log.info("EmployeeController.save - end - saved employee with id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PutMapping("/employees/{id}")
    public EmployeeDocument update(@PathVariable("id") String id, @RequestBody EmployeeDocument  employeeDocument) {
        log.info("EmployeeController.update - start - updating employee with id: {}", id);
        EmployeeDocument response = employeeService.update(employeeDocument, id);
        log.info("EmployeeController.update - end - updated employee with id: {}", response.getId());
        return response;
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        log.info("EmployeeController.delete - start - deleting employee with id: {}", id);
        employeeService.delete(id);
        log.info("EmployeeController.delete - end - deleted employee with id: {}", id);
    }

}
