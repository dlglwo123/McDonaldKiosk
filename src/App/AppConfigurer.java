package App;

import App.Discount.*;
import App.Product.Product;
import App.Product.ProductRepository;

public class AppConfigurer {

    private Cart cart = new Cart(menu(),productRepository());
    public ProductRepository productRepository(){
        return new ProductRepository();
    }

    public Menu menu(){
        return new Menu(productRepository().getProduct());
    }

    public Cart cart(){
        return cart;
    }
    public Discount discount(){
        return new Discount(new DiscountCountCondition[]{
                new MemvershipDiscountConditionCountCondition(new FixedAmountDiscountPolicy(500)),
                new RegularDiscountConditionCountCondition(new FixedRateDiscountPolicy(10))
        });
    }
    public Order order(){
        return new Order(cart(),discount());
    }
}
