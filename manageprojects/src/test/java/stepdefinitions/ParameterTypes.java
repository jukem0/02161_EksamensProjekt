package stepdefinitions;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import com.projectmanager.model.Week;

import io.cucumber.java.ParameterType;

public class ParameterTypes {

    @ParameterType("\\d{4}-\\d{2}-\\d{2}")
    public LocalDate LocalDate(String dateString) {
        return LocalDate.parse(dateString);
    }

    @ParameterType("\\d{4}-\\d{2}-\\d{2}") // YYYY-MM-DD
    public Week Week(String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        int weekNum = date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        int year = date.get(IsoFields.WEEK_BASED_YEAR);
        return new Week(weekNum, year);
    }
}
