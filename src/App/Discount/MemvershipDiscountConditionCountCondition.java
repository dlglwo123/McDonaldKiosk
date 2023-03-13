package App.Discount;

import java.util.Scanner;

public class MemvershipDiscountConditionCountCondition implements DiscountCountCondition {

    private boolean isSatisfied;
    Scanner sc = new Scanner(System.in);
    private DiscountPolicy discountPolicy;

    public MemvershipDiscountConditionCountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void checkDiscountCondition() {
        System.out.println("[System] Mc Donald의 멤버쉽이 있으십니까?  (1)_예  (2)_아니오");
        int Input = sc.nextInt();

        if(Input == 1) setFirst(true);
        else if(Input == 2) setFirst(false);
    }

    public int applyDiscount(int price){
        int total = price;
        if(isSatisfied()) total = discountPolicy.CalcAmountDiscount(price);
        return total;
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

    public void setFirst(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
    }
}
