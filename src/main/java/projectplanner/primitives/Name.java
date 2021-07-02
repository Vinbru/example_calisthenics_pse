package projectplanner.primitives;

import java.io.PrintStream;

public class Name {
    private String name;

    public Name(String input_name){
        this.name = input_name;
    }

    public void print(PrintStream out){
        out.print(this.name);
    }

	public Money addPaymentIfNameEqualsName(Name name, Money output, Money member_payment) {
    	if(this.name.equals(name.name)){
    		output = output.addMoney(member_payment);
		}
    	return output;
	}
}
