package App.Discount;

public class FixedRateDiscountPolicy implements DiscountPolicy {
    private int RateDiscount;

    public FixedRateDiscountPolicy(int RateDiscount) {
        this.RateDiscount = RateDiscount;
    }

    public int CalcAmountDiscount(int price) //할인을 적용해서 계산하는 메서드
    {
        int total = 0;
        return total = price - (price * RateDiscount/100);
    }
}
