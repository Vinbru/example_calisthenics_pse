package projectplanner.date;

import projectplanner.primitives.*;
import java.io.PrintStream;

public class DateDay extends DateMonth implements Date {
    private Day day;

    public DateDay(int day_input, int month_input, int year_input){
        super(month_input, year_input);
        day = new Day(day_input);
    }

    public void print(PrintStream out){
        day.print(out);
        out.print(".");
        super.print(out);
    }
}
