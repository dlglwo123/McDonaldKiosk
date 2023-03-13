package App.Product.SubProduct;

import App.Product.Product;

public class Hamburger extends Product {
    private boolean isburgerSet; //햄버거세트가 맞는지 안맞는지 확인하는 변수
    private int BurgerSetPrice; // 햄버거 세트가 맞을경우 고정된 햄버거 세트의 가격

    //햄버거 세트가 맞는지 아닌지의 여부에 따라 햄버거 세트의 가격이 결정되기 때문에 getter,setter 모두 생성
    //햄버거 세트가격은 생성자에 따로 초기화 시키지 않는다. 초기화시 false로 한뒤 true

    public Hamburger(int id, String name, int price,int kcal,boolean isburgerSet,int BurgerSetPrice) {
        super(id, name, price,kcal);
        this.isburgerSet = isburgerSet;
        this.BurgerSetPrice = BurgerSetPrice;
    }
    public Hamburger(Hamburger hamburger) // 깊은 복사를 위해서 만든 생성자
    {
        super(hamburger.getName(),hamburger.getPrice(),hamburger.getKcal());
        this.isburgerSet = hamburger.isburgerSet;
        this.BurgerSetPrice = hamburger.BurgerSetPrice;
    }

    public boolean GetIsburgerSet() {
        return isburgerSet;
    }

    public void setIsburgerSet(boolean isburgerSet) {
        this.isburgerSet = isburgerSet;
    }

    public int getBurgerSetPrice() {
        return BurgerSetPrice;
    }

    public void setBurgerSetPrice(int burgerSetPrice) {
        BurgerSetPrice = burgerSetPrice;
    }
}
/*
    [문제해결]
    케첩같은 경우 값이 중복되어 따로 나오지 않고 값이 같게 되는경우가 생긴다.
    얕은 복사 : 객체의 참조값을 복사하는것
    깊은 복사 : 내용은 동일하지만 참조값이 다른 새로운 객체를 생성하는것을 의미한다.
    결과적으로 햄버거,사이드,음료같은 경우 같은 참조값을 가지고 있기때문에 가리키는 객체가 같게된다. 그래서 깊은 복사를 통해 내용은 같지만 참조값이 다른 새로운 객체를 생성한다.
 */