package org.fasttrackit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Country {
    private Integer id;
    private String name;
    private String capital;
    private Integer population;
    private Integer area;
    private String continent;
    private String neighbour;


}
