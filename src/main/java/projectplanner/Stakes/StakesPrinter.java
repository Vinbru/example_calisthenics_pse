package projectplanner.Stakes;

import projectplanner.Member;
import projectplanner.primitives.*;
import java.io.PrintStream;

public class StakesPrinter {
    private Member[] members;
    private Money[][] stake_matrix;

    StakesPrinter(Member[] members, Money[][] matrix){
        this.members = members;
        this.stake_matrix = matrix;
    }

    void print(PrintStream out){
    	Money sum = sumOfOpenStakes();
        for(int i = 0; i < this.stake_matrix.length; i++){
            stake_matrix[i][i].printStakesIfNegative(out, i, sum, this);
        }
    }

    public void printStakes(PrintStream out, int i, Money sum){
		members[i].print(out);
		out.print(" gets money from: ");
		for(int j = 0; j < this.stake_matrix[i].length; j++) {
			this.stake_matrix[j][j].printStakesLineIfPositive(out, i, j, sum, this);
		}
		out.println();
	}

    public void printStakesLine(PrintStream out, int i, int j, Money sum){
            members[j].print(out);
            out.print(": ");
            Money personal_stake = this.stake_matrix[j][j].multiplyWith(this.stake_matrix[i][i].dividedBy(sum));
            personal_stake.printAbsolute(out);
            out.print(", ");
    }

    private Money sumOfOpenStakes() {
        Money output = new Money(0);
        for(int i = 0; i < this.stake_matrix.length; i++) {
            output = output.addMoney(stake_matrix[i][i].absoluteOfThis());
        }
        return(new Money(output.dividedBy(new Money(2))));
    }
}
