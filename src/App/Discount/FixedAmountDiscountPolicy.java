package App.Discount;

public class FixedAmountDiscountPolicy implements DiscountPolicy {
    private int AmountDiscount;

    public FixedAmountDiscountPolicy(int amountDiscount) {
        AmountDiscount = amountDiscount;
    }

    public int CalcAmountDiscount(int price) //할인을 적용해서 계산하는 메서드
    {
        return price = price - AmountDiscount;
    }
}
