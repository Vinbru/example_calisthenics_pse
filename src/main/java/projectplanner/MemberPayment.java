package projectplanner;

import projectplanner.primitives.*;
import java.io.PrintStream;

public class MemberPayment {
    private Member member;
    private Money amount;

    public MemberPayment(Member member_input, Money amount_input) {
        this.member = member_input;
        this.amount = amount_input;
    }

    public Money addPaymentTo(Money money_input){
        return(money_input.addMoney(this.amount));
    }

    public void print(PrintStream out){
        member.print(out);
        out.print(" payed: ");
        amount.print(out);
    }

	public Money addPaymentIfMemberIsPayer(Member member_input, Money output) {
    	output = this.member.addPaymentIfMemberEqualsMember(member_input, output, this.amount);
    	return output;
	}
}
