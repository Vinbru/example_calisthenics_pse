package projectplanner.primitives;

import java.io.PrintStream;
import projectplanner.Stakes.StakesPrinter;

public class Money {
    private double amount;

    public Money(double double_input){
        this.amount = double_input;
    }

    public Money multiplyWith(double multiplier){
        return(new Money(this.amount * multiplier));
    }

    public double dividedBy(Money divisor){
        return(this.amount / divisor.amount);
    }

    public Money addMoney(Money added_money){
        return(new Money(this.amount + added_money.amount));
    }

    public Money subtractMoney(Money subtracted_money){
        return(new Money (this.amount - subtracted_money.amount));
    }

    public Money absoluteOfThis(){
        if(this.amount < 0) {
            return(new Money (this.amount * -1));
        }
        return(new Money(this.amount));
    }

    public void print(PrintStream out) {
        out.print((int) this.amount);
        out.print(",");
        out.print((int) ((this.amount - (int) this.amount) * 100));
        out.print("Euro");
    }

    public void printAbsolute(PrintStream out) {
        absoluteOfThis().print(out);
    }

    public void printStakesIfNegative(PrintStream out, int i, Money sum, StakesPrinter stakesPrinter){
    	if(this.amount < 0){
    		stakesPrinter.printStakes(out, i, sum);
		}
	}

	public void printStakesLineIfPositive(PrintStream out, int i, int j, Money sum, StakesPrinter stakesPrinter) {
    	if(this.amount > 0){
    		stakesPrinter.printStakesLine(out, i, j, sum);
		}
	}
}
