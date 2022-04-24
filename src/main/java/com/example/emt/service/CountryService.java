package com.example.emt.service;

import com.example.emt.model.Country;
import com.example.emt.model.dto.CountryDto;
import com.example.emt.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> listCountries() {
        return countryRepository.findAll();
    }

    public Country getCountry(Long id) {
        return countryRepository.getById(id);
    }

    public boolean doesCountryExist(String name) {
        return countryRepository.findByName(name).isPresent();
    }

    public Country createCountry(CountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return countryRepository.save(country);
    }
}
