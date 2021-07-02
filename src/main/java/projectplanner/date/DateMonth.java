package projectplanner.date;


import projectplanner.primitives.*;
import java.io.PrintStream;

public class DateMonth extends DateYear implements Date {
    private Month month;

    public DateMonth(int month_input, int year_input){
        super(year_input);
        this.month = new Month(month_input);
    }

    public void print(PrintStream out){
        month.print(out);
        out.print(".");
        super.print(out);
    }
}
