package projectplanner;

import java.io.PrintStream;

public class Project {
    private Identifier date_and_name;
    private ProjectFinances project_finances;

    public Project(Identifier date_and_name_input, Member[] members){
        this. date_and_name = date_and_name_input;
        this. project_finances = new ProjectFinances(members);
    }

    public void addActivity(Identifier date_and_name, Member[] activity_members, Receipt receipt_input){
        project_finances.addActivity(date_and_name,activity_members,receipt_input);
    }

    public void print(PrintStream out){
        date_and_name.print(out);
        out.println();
        project_finances.print(out);
    }

}
