package App.Discount;

public interface DiscountCountCondition {
    boolean isSatisfied();
    public void checkDiscountCondition();
    public int applyDiscount(int price);

}
