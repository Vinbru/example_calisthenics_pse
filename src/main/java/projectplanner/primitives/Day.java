package projectplanner.primitives;

import java.io.PrintStream;

public class Day {
    private int day;

    public Day(int day_input){
        if(valid(day_input) == true){
            this.day = day_input;
        }
    }

    private boolean valid(int day_input){
        boolean output = true;
        if(day_input > 31 || day_input < 1){
            output = false;
            // Fehlermeldung
        }
        return output;
    }

    public void print(PrintStream out){
        if(this.day < 10){
            out.print("0");
        }
        out.print(this.day);
    }
}