package projectplanner.Stakes;

import projectplanner.Member;
import projectplanner.MemberPayment;
import projectplanner.primitives.*;
import java.io.PrintStream;

public class Stakes {
    private Member[] members;
    private Money[][] stake_matrix;

    public Stakes(Member[] member_input){
        this.members = member_input;
        this.stake_matrix = new Money[member_input.length][member_input.length];
        StakeMatrixCreator creator = new StakeMatrixCreator(member_input,member_input);
        creator.insertZero(this.stake_matrix);
    }

	public Stakes(Stakes project_stakes, Member[] activity_members, Money bill, MemberPayment[] payedBy) {
		this.members = project_stakes.members;
		Member[] project_members = project_stakes.members;
		this.stake_matrix = new Money[project_members.length][project_members.length];
		StakeMatrixCreator creator = new StakeMatrixCreator(project_members,activity_members);
		creator.insertZero(this.stake_matrix);
		creator.insertStakes(this.stake_matrix,bill, payedBy);
	}

	public void addStakes(Stakes project_stakes){
        for(int i = 0; i < stake_matrix.length; i++){
            project_stakes.stake_matrix[i][i] = stake_matrix[i][i].addMoney(project_stakes.stake_matrix[i][i]);
        }
    }

    public void print(PrintStream out){
        StakesPrinter printer = new StakesPrinter(this.members,this.stake_matrix);
        printer.print(out);
    }

}
