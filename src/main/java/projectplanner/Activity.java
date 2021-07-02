package projectplanner;

import projectplanner.Stakes.Stakes;

import java.io.PrintStream;

public class Activity {
    private Identifier date_and_name;
    private ActivityFinances activity_finances;

    public Activity(Identifier date_and_name, Stakes project_stakes, Member[] activity_members, Receipt receipt_input) {
        this.date_and_name = date_and_name;
        this.activity_finances = new ActivityFinances(project_stakes, activity_members, receipt_input);
    }

    public void print(PrintStream out){
        this.date_and_name.print(out);
        out.println();
        out.print("------------------------------------");
        this.activity_finances.print(out);
        out.print("------------------------------------");
        out.println();
    }
}
