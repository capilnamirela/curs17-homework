package org.fasttrackit;

import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


@Data
@Builder
public class CountryFromFile {

    private static List<Country> countryList = new ArrayList<>();

    public static List<Country> countryList() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/resources", "countries.txt"));
        int id = 0;

        while (scanner.hasNext()) {
            id++;
            String[] line = scanner.nextLine().split(Pattern.quote("|"));

            String neighbour;
            if (line.length > 5) {
                neighbour = line[5];
            } else {
                neighbour = "";

            }
            countryList.add(Country.builder()
                    .id(id)
                    .name(line[0])
                    .capital(line[1])
                    .population(Integer.parseInt(line[2]))
                    .area(Integer.parseInt(line[3]))
                    .continent(line[4])
                    .neighbour(neighbour)
                    .build());

        }
        return countryList;

    }


}



