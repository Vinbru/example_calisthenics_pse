package projectplanner;

import projectplanner.Stakes.Stakes;
import projectplanner.primitives.*;
import java.io.PrintStream;

public class Receipt {
    private Money bill;
    private MemberPayment[] payedBy;

    public Receipt(MemberPayment[] payedBy_input) {
        this.bill = createBill(payedBy_input);
        this.payedBy = payedBy_input;
    }

    private Money createBill(MemberPayment[] memberPayment_input){
        Money output = new Money(0);
        for(int i = 0; i < memberPayment_input.length; i++){
            output = memberPayment_input[i].addPaymentTo(output);
        }
        return(output);
    }

    public void print(PrintStream out){
        out.println();
        out.print("The bill was: ");
        bill.print(out);
        for(int i = 0; i < payedBy.length; i++) {
            out.print(" | ");
            payedBy[i].print(out);
        }
    }

	public Stakes generateStakes(Stakes project_stakes, Member[] activity_members) {
    	return(new Stakes(project_stakes,activity_members,this.bill,this.payedBy));
	}
}
