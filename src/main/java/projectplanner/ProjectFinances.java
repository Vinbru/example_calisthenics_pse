package projectplanner;

import projectplanner.Stakes.Stakes;

import java.io.PrintStream;
import java.util.ArrayList;

public class ProjectFinances {
    private Stakes stakes;
    private ArrayList<Activity> activities;

    public ProjectFinances(Member[] members_input){
        this.stakes = new Stakes(members_input);
        this.activities = new ArrayList<>();
    }

    public void addActivity(Identifier date_and_name, Member[] activity_members, Receipt receipt_input){
        Activity added_activity = new Activity (date_and_name,this.stakes,activity_members,receipt_input);
        this.activities.add(added_activity);
    }

    public void print(PrintStream out){
        stakes.print(out);
        out.println();
        for(int i = 0; i < this.activities.size(); i++){
            Activity printed_activity = activities.get(i);
            printed_activity.print(out);
            out.println();
        }
    }
}
