package App.Product;

import App.Product.SubProduct.Drink;
import App.Product.SubProduct.Hamburger;
import App.Product.SubProduct.Side;

public class ProductRepository {

    // 업캐스팅 : Product 저장소 - 배열을 선언해서 제품을 담는다.
    private static final Product PRODUCT[]= {
            new Hamburger(1, "빅맥",4500,583,false,5500),
            new Hamburger(2, "맥스파이시 상하이 버거",4500,441,false,5500),
            new Hamburger(3,"슈비버거",5500,563,false,6900),
            new Hamburger(4, "베이컨 토마토 디럭스",5100,545,false,6700),
            new Side(5,"감자튀김",1700,229,1),
            new Side(6,"맥너겟",1800,171,1),
            new Side(7,"상하이 치킨 스낵랩",2000,303,1),
            new Drink(8,"코카콜라",1300,101,true),
            new Drink(9,"코카콜라",1300,101,true)
    };
    public Product[] getProduct()
    {
        return PRODUCT;
    }
    public Product FindById(int productId) // 함수 FinbyId는 업캐스팅이 된 상태이다.
    {
        for(Product product : PRODUCT){
            if(product.getId() == productId){
                return product;
            }
        }
        return null;
    }
}
