package projectplanner.primitives;

import java.io.PrintStream;

public class Year {
    private int year;

    public Year(int year_input) {
        this.year = year_input;
    }

    public void print(PrintStream out){
        out.print(this.year);
    }
}
