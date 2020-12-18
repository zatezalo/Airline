package rs.raf.Airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.raf.Airline.model.City;
import rs.raf.Airline.model.Company;
import rs.raf.Airline.repositories.custom.services.CityService;
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
}
