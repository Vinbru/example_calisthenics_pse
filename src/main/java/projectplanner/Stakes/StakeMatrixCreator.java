package projectplanner.Stakes;

import projectplanner.Member;
import projectplanner.MemberPayment;
import projectplanner.primitives.*;

class StakeMatrixCreator{
    private Member[] project_members;
    private Member[] activity_members;

    StakeMatrixCreator(Member[] project_members, Member[] activity_members){
        this.project_members = project_members;
        this.activity_members = activity_members;
    }

    void insertZero(Money[][] matrix){
        for(int i = 0; i < matrix.length; i++) {
            fillLineZero(matrix,i);
        }
    }

    void insertStakes(Money[][] matrix, Money bill, MemberPayment[] payedBy){
        insertAverage(matrix, bill);
        subtractMemberPayments(matrix,payedBy);
    }

    private void insertAverage(Money[][] matrix, Money bill){
        Money average_payment = new Money(bill.dividedBy(new Money(activity_members.length)));
        for(int i = 0; i < matrix.length; i++) {
            insertToMember(i,average_payment,matrix);
        }
    }

    private void insertToMember(int i, Money average_payment, Money[][] matrix){
        for(int j = 0; j < activity_members.length; j++) {
        	matrix[i][i] = project_members[i].addPaymentIfMemberEqualsMember(activity_members[j],matrix[i][i],average_payment);
        }
    }

    private void fillLineZero(Money[][] matrix, int i){
        for(int j = 0; j < matrix[i].length; j++){
            matrix[i][j] = new Money(0);
        }
    }

    private void subtractMemberPayments(Money[][] matrix, MemberPayment[] payedBy){
        for(int i = 0; i < project_members.length; i++){
            matrix[i][i] = matrix[i][i].subtractMoney(howMuchDidMemberPay(project_members[i],payedBy));
        }
    }

    private Money howMuchDidMemberPay(Member member_input,MemberPayment[] payedBy){
        Money output = new Money(0);
        for(int i = 0; i < payedBy.length; i++){
            output = payedBy[i].addPaymentIfMemberIsPayer(member_input, output);
        }
        return(output);
    }
}
