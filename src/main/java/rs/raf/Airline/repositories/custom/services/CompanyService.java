package rs.raf.Airline.repositories.custom.services;

import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.dto.companyDto.AddCompanyDto;
import rs.raf.Airline.model.dto.companyDto.CompanyDto;
import rs.raf.Airline.model.dto.companyDto.EditCompanyDto;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    CompanyDto getCompanyAndTickets(Long id);
    String deleteCompany(Long id);
    String addCompany(AddCompanyDto addCompanyDto);
    String editCompany(EditCompanyDto editCompanyDto);
}
