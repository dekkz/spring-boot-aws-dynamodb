package br.com.dkzit.project.services;

import br.com.dkzit.project.documents.EmployeeDocument;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    EmployeeDocument save(EmployeeDocument employee);
    EmployeeDocument update(EmployeeDocument employee, String id);
    Optional<EmployeeDocument> getById(String id);
    List<EmployeeDocument> getAll();
    void delete(String id);

}
