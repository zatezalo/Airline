package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import rs.raf.Airline.model.City;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.Ticket;
import rs.raf.Airline.model.dto.companyDto.CompanyDto;
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


}
