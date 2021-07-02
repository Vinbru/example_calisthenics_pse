package projectplanner.primitives;

import java.io.PrintStream;

public class Month {
    private int month;

    public Month(int month_input){
        if(valid(month_input) == true){
            this.month = month_input;
        }
    }

    private boolean valid(int month_input){
        boolean output = true;
        if(month_input > 12 || month_input < 1){
            output = false;
            // Fehlermeldung
        }
        return output;
    }

    public void print(PrintStream out){
        if(this.month < 10) {
            out.print("0");
        }
        out.print(this.month);
    }
}