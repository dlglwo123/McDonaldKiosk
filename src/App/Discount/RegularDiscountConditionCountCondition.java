package App.Discount;
import java.util.Scanner;

public class RegularDiscountConditionCountCondition implements DiscountCountCondition {

    Scanner sc = new Scanner(System.in);
    private boolean isSatisfied;
    private DiscountPolicy discountPolicy;

    public RegularDiscountConditionCountCondition(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }
    public void checkDiscountCondition() {
        System.out.println("[System] Mc Donald의 단골이십니까?  (1)_예  (2)_아니오");
        int Input = sc.nextInt();

        if(Input == 1) setRegular(true);
        else if(Input == 2) setRegular(false);
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }
    public void setRegular(boolean isSatisfied) {
        this.isSatisfied = isSatisfied;
    }

    public int applyDiscount(int price){
        int total = price;
        if(isSatisfied()) total = discountPolicy.CalcAmountDiscount(price);
        return total;
    }
}
