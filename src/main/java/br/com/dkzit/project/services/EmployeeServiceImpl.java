package br.com.dkzit.project.services;

import br.com.dkzit.project.documents.EmployeeDocument;
import br.com.dkzit.project.exceptions.DataNotFoundException;
import br.com.dkzit.project.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDocument save(EmployeeDocument employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDocument update(EmployeeDocument employee, String id) {

        Optional<EmployeeDocument> employeeExists = employeeRepository.findById(id);
        if(employeeExists.isPresent()) {
            employeeExists.get().setFirstName(employee.getFirstName());
            employeeExists.get().setLastName(employee.getLastName());
            employeeExists.get().setEmail(employee.getEmail());
            employeeExists.get().setPhone(employee.getPhone());
            employeeExists.get().setDepartment(employee.getDepartment());
            employeeExists.get().setSalary(employee.getSalary());

            return employeeRepository.save(employeeExists.get());
        }
        throw new DataNotFoundException("Employee ID not found");
    }

    @Override
    public Optional<EmployeeDocument> getById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<EmployeeDocument> getAll() {
        return (List<EmployeeDocument>) employeeRepository.findAll();
    }

    @Override
    public void delete(String id) {
        employeeRepository.deleteById(id);
    }
}
