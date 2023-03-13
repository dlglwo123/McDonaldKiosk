package App.Product;
// 제품 공통정보 추출하기
public class Product {
    private int id;
    private String Name;
    private int Kcal;
    private int Price;

    public Product(int id, String name, int price,int kcal) {
        this.id = id;
        Name = name;
        Price = price;
        Kcal = kcal;
    }
    public Product(String name, int price,int kcal) //HamburgerSet : 생성자 오버로딩
    {
        Name = name;
        Price = price;
        Kcal = kcal;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getKcal() {
        return Kcal;
    }

    public void setKcal(int kcal) {
        Kcal = kcal;
    }
}
