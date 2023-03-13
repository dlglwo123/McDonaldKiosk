package App.Discount;

public class Discount {
    private DiscountCountCondition[] discountCountConditions;

    public Discount(DiscountCountCondition[] discountCountConditions){
        this.discountCountConditions = discountCountConditions;
    }
    public int discount(int price){
        int discountPrice = price;
        for(DiscountCountCondition discounts : discountCountConditions){
            discounts.checkDiscountCondition();
            if(discounts.isSatisfied()) discountPrice = discounts.applyDiscount(discountPrice);
        }
        return discountPrice;
    }
}
