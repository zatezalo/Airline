package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rs.raf.Airline.exeptions.ApiRequestException;
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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/addCompany")
    public String addCompany(@RequestBody AddCompanyDto addCompanyDto){
        if(addCompanyDto.getName().length() > 0 || addCompanyDto.getName().equals(""))
            throw new ApiRequestException("The company name can't be null!");
        return companyService.addCompany(addCompanyDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/editCompany")
    public String editCompany(@RequestBody EditCompanyDto editCompanyDto) {
        if(editCompanyDto.getName().length() > 0 || editCompanyDto.getName().equals(""))
            throw new ApiRequestException("The company name can't be null!");
        return companyService.editCompany(editCompanyDto);
    }
}
