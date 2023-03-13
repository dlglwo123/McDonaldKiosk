package App.Product.SubProduct;

import App.Product.Product;

public class Side extends Product {

    private int isketchup; // 케첩의 개수 여부;

    // 케첩의 개수를 입력받고 입력받은 값을 저장해야하기 때문에 getter,setter 모두 생성

    public Side(int id, String name, int price,int kcal, int isketchup) {
        super(id, name, price,kcal);
        this.isketchup = isketchup;
    }
    public Side(Side side) {
        super(side.getId(),side.getName(),side.getPrice(),side.getKcal());
        this.isketchup = side.getIsketchup();
    }

    public int getIsketchup() {
        return isketchup;
    }

    public void setIsketchup(int isketchup) {
        this.isketchup = isketchup;
    }

}
