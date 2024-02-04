package org.fasttrackit;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class CountryService {
    static List<Country> countryService = new ArrayList<>();

    public CountryService() throws FileNotFoundException {
        countryService = CountryFromFile.countryList();
    }


    public static List<String> listAllCountryNames(List<Country> countryService) {
        List<String> countryNames = countryService.stream()
                .map(Country::getName)
                .toList();
        return countryNames;
    }

    public static String getCapitalOfACountry(String countryName) {
        String capital = countryService.stream()
                .filter(country -> country.getName().equals(countryName))
                .map(Country::getCapital)
                .findFirst()
                .orElse("nu exista");
        return capital;
    }

    public static Long getPopulationOfACountry(String countryName) {
        Long population = Long.valueOf(countryService.stream()
                .filter(country -> country.getName().equals(countryName))
                .map(Country::getPopulation)
                .findFirst()
                .orElse(0));
        return population;
    }

    public static List<Country> getCountriesInTheContinent(String continent) {
        List<Country> continentList = countryService.stream()
                .filter(country -> country.getContinent().equals(continent))
                .toList();
        return continentList;
    }

    public static List<String> getCountryNeighbours(String countryName) {
        List<String> neighbours = countryService.stream()
                .filter(country -> country.getName().equals(countryName))
                .flatMap(country -> Arrays.stream(country.getNeighbour().split("~")))
                .toList();
        return neighbours;
    }

    public static List<Country> getCountriesContinentPopulation(String continentName, Long population) {
        List<Country> countries = countryService.stream()
                .filter(country -> country.getContinent().equals(continentName))
                .filter(country -> country.getPopulation() > population)
                .toList();
        return countries;
    }

    public static List<Country> countryNeighbourXNotY(String countryName1, String countryName2) {
        List<Country> countryList = countryService.stream()
                .filter(country -> country.getNeighbour().contains(countryName1))
                .filter(country -> !country.getNeighbour().contains(countryName2))
                .toList();
        return countryList;
    }


}




