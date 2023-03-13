package App.Product.SubProduct;

import App.Product.Product;

public class Drink extends Product {

    private boolean HasStraw; // 빨대 보유 여부

    // 빨대 보유 여부 true false 값에 따라 변하기 때문에 getter,setter 모두 선언

    public Drink(int id, String name, int price ,int kcal, boolean HasStraw) {
        super(id, name, price,kcal);
        this.HasStraw = HasStraw;
    }
    public Drink(Drink drink) {
        super(drink.getName(), drink.getPrice(), drink.getKcal());
        this.HasStraw = drink.HasStraw;
    }

    public boolean HasStraw() {
        return HasStraw;
    }

    public void setStraw(boolean Hastraw) {
        HasStraw = Hastraw;
    }
}
