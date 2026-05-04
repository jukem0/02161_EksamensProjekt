package stepdefinitions;

import java.time.LocalDate;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("\\d{4}-\\d{2}-\\d{2}")
    public LocalDate LocalDate(String dateString) {
        return LocalDate.parse(dateString);
    }
    
    // Her kan du også tilføje din {medarbejder} type senere
}
