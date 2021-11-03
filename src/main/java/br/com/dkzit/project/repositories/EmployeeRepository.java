package br.com.dkzit.project.repositories;

import br.com.dkzit.project.documents.EmployeeDocument;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeDocument, String> {
}
