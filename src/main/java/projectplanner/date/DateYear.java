package projectplanner.date;

import projectplanner.primitives.*;
import java.io.PrintStream;

public class DateYear implements Date {
    private Year year;

    public DateYear(int year_input) {
        this.year = new Year(year_input);
    }

    public void print(PrintStream out){
        year.print(out);
    }
}
