package projectplanner;

import projectplanner.primitives.*;
import projectplanner.date.*;
import java.io.PrintStream;

public class Identifier {
    private Date date;
    private Name name;

    public Identifier(Date date_input, Name name_input) {
        this.date = date_input;
        this.name = name_input;
    }

    public void print(PrintStream out){
        out.print("Date: ");
        this.date.print(out);
        out.print(" Project/Activity: ");
        this.name.print(out);
    }
}
