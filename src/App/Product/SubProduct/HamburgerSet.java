package App.Product.SubProduct;

import App.Product.Product;

// 햄버거 세트는 햄버거 클래스에서 햄버거 세트인지 아닌지로 판별하고 햄버거 + 사이드 + 음료를 추가적으로 고를 수 있어야함
public class HamburgerSet extends Product{
    private Hamburger hamburger;
    private Side side;
    private Drink drink;

    public HamburgerSet(int id, String name, int price, int kcal, Hamburger hamburger, Side side, Drink drink) {
        super(id, name, price, kcal);
        this.hamburger = hamburger;
        this.side = side;
        this.drink = drink;
    }
    public HamburgerSet(String name, int price, int kcal, Hamburger hamburger, Side side, Drink drink) {
        super(name, price, kcal);
        this.hamburger = hamburger;
        this.side = side;
        this.drink = drink;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }
    public Side getSide() {
        return side;
    }

    public Drink getDrink() {
        return drink;
    }

}
