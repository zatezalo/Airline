package rs.raf.Airline.repositories.custom.services;

import rs.raf.Airline.model.City;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.dto.companyDto.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    CompanyDto getCompanyAndTickets(Long id);
}
