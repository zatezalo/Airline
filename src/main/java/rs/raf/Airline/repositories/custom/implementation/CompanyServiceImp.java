package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.companyDto.AddCompanyDto;
import rs.raf.Airline.model.dto.companyDto.CompanyDto;
import rs.raf.Airline.model.dto.companyDto.EditCompanyDto;
import rs.raf.Airline.repositories.CompanyRepository;
import rs.raf.Airline.repositories.TicketRepository;
import rs.raf.Airline.repositories.custom.services.CompanyService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<Company>();

        for (Company company : companyRepository.findAll()) {
            companies.add(company);
        }
        return companies;
    }

    @Override
    public CompanyDto getCompanyAndTickets(Long id) {
        Company company = companyRepository.findById(id).get();
        List<Ticket> tickets = ticketRepository.findAllByCompany_Id(id);
        CompanyDto companyDto = new CompanyDto();
        companyDto.setName(company.getName());
        companyDto.setTickets(tickets);
        return companyDto;
    }

    @Override
    public String deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return "Company Deleted!!!";
    }

    @Override
    public String addCompany(AddCompanyDto addCompanyDto) {
        Company company = new Company();
        company.setName(addCompanyDto.getName());
        companyRepository.save(company);
        return "Company Created!!!";
    }

    @Override
    public String editCompany(EditCompanyDto editCompanyDto) {
        Company company = companyRepository.findById(editCompanyDto.getId()).get();
        company.setName(editCompanyDto.getName());
        companyRepository.save(company);
        return "Company Edited!!!";
    }


}
