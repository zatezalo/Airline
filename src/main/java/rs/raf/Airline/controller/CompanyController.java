package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.model.dto.companyDto.AddCompanyDto;
import rs.raf.Airline.model.dto.companyDto.CompanyDto;
import rs.raf.Airline.model.dto.companyDto.EditCompanyDto;
import rs.raf.Airline.repositories.custom.services.CompanyService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/getCompany/{id}")
    public CompanyDto getCompanyAndTickets(@PathVariable("id") Long id) {
        return companyService.getCompanyAndTickets(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") Long id){
        return companyService.deleteCompany(id);
    }

    @PostMapping("/addCompany")
    public String addCompany(@RequestBody AddCompanyDto addAndEditCompanyDto){
        return companyService.addCompany(addAndEditCompanyDto);
    }

    @PutMapping("/editCompany")
    public String editCompany(@RequestBody EditCompanyDto editCompanyDto) {
        return companyService.editCompany(editCompanyDto);
    }
}
