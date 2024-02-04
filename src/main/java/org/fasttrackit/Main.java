package org.fasttrackit;

import lombok.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.fasttrackit.CountryService.*;

@Data
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        CountryService countryService = new CountryService();
        List<Country> countryList = new ArrayList<>();
        countryList.addAll(CountryService.countryService);

        System.out.println(countryList);
        System.out.println(listAllCountryNames(countryList));
        System.out.println(getCapitalOfACountry("Isle of Man"));
        System.out.println(getPopulationOfACountry("Afghanistan"));
        System.out.println(getCountriesInTheContinent("Oceania"));
        System.out.println(getCountryNeighbours("Afghanistan"));
        System.out.println(getCountriesContinentPopulation("Africa", 55000000L));
        System.out.println(countryNeighbourXNotY("ROU", "BGR"));

    }
}