package com.example.emt.controller;

import com.example.emt.model.Country;
import com.example.emt.model.dto.CountryDto;
import com.example.emt.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll() {
        return this.countryService.listCountries();
    }

    @PostMapping
    public Country createCountry(@RequestBody CountryDto countryDto) {
        return this.countryService.createCountry(countryDto);
    }
}
