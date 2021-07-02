package projectplanner;

import projectplanner.primitives.*;
import java.io.PrintStream;

public class Member {
    private Name name;

    public Member(Name name_input){
        this.name = name_input;
    }

    public void print (PrintStream out){
        this.name.print(out);
    }

	public Money addPaymentIfMemberEqualsMember(Member member_input, Money output, Money member_payment) {
    	output = name.addPaymentIfNameEqualsName(member_input.name, output, member_payment);
    	return output;
	}
}
