package App;

import App.Discount.*;

public class Order {
    private Cart cart;

    private Discount discountConditon;

    //MemvershipDiscountCondition memvershipDiscountCondition = new MemvershipDiscountCondition(new FixedRateDiscountPolicy(50));
    //RegularDiscountCondition regularDiscountCondition = new RegularDiscountCondition(new FixedAmountDiscountPolicy(400));

    public Order(Cart cart, Discount discount){
        this.cart = cart;
        this.discountConditon = discount;
    }
    public void makeOrder(){

        int total = cart.CalculateTotalPrice(); // 할인율을 적용하지 않은 금액

        System.out.println("[📣] 주문이 완료되었습니다. ");
        System.out.println("[📣] 주문 내역은 다음과 같습니다. ");
        System.out.println("-".repeat(60));

        cart.printCartItemDetails();
        int finalTotal = discountConditon.discount(total);

        System.out.println("-".repeat(60));
        System.out.printf("금액 합계      : %d원\n", total);
        System.out.printf("할인 적용 금액 : %d원\n", finalTotal);
    }
}
