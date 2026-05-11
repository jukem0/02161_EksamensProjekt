package stepdefinitions;

import com.projectmanager.model.Week;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("\\d{4}-\\d{2}") // YYYY-WW
    public Week Week(String dateString) {
        String[] parts = dateString.split("-");
        int year = Integer.parseInt(parts[0]);
        int weekNum = Integer.parseInt(parts[1]);
        return new Week(weekNum, year);
    }
}
