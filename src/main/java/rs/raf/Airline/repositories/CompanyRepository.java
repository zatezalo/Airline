package rs.raf.Airline.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.raf.Airline.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    Company findCompanyByName(String name);
}
