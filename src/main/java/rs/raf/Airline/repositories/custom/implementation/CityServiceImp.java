package rs.raf.Airline.repositories.custom.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.raf.Airline.model.City;
import rs.raf.Airline.repositories.CityRepository;
import rs.raf.Airline.repositories.custom.services.CityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImp implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities() {
        List<City> cities = new ArrayList<City>();

        for (City city : cityRepository.findAll()) {
            cities.add(city);
        }

        return cities;
    }
}
