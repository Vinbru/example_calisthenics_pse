package projectplanner;

import projectplanner.Stakes.Stakes;

import java.io.PrintStream;

public class ActivityFinances {
    private Stakes stakes;
    private Receipt receipt;

    public ActivityFinances(Stakes project_stakes, Member[] activity_members, Receipt receipt_input){
		this.stakes = receipt_input.generateStakes(project_stakes, activity_members);
        addStakesToProject(project_stakes);
        this.receipt = receipt_input;
    }

    private void addStakesToProject(Stakes project_stakes){
        this.stakes.addStakes(project_stakes);
    }

    public void print(PrintStream out){
        receipt.print(out);
        out.println();
        stakes.print(out);
    }

}
