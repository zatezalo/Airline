package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.City;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.repositories.CompanyRepository;
import rs.raf.Airline.repositories.custom.services.CompanyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();

        for (Company company : companyRepository.findAll()) {

            companies.add(company);
        }
        return companies;
    }
}
