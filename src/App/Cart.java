package App;

import App.Product.Product;
import App.Product.ProductRepository;
import App.Product.SubProduct.Drink;
import App.Product.SubProduct.Hamburger;
import App.Product.SubProduct.HamburgerSet;
import App.Product.SubProduct.Side;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Scanner;

public class Cart {

    private Menu menu;
    private Product[] items = new Product[0]; //처음엔 장바구니에 아무것도 없기때문에 0으로 초기화
    ProductRepository productRepository = new ProductRepository();
    Scanner sc = new Scanner(System.in);

    public Cart(Menu menu,ProductRepository productRepository){
        this.menu = menu;
        this.productRepository = productRepository;
    }


    public void addToCart(int productID) // 장바구니 총 집합소
    {

        Product product = productRepository.FindById(productID); // 장바구니에 담을 제품을 찾는다.

        //깊은 복사
        Product newProduct;
        if(product instanceof Hamburger) newProduct = new Hamburger((Hamburger) product);
        else if(product instanceof Side) newProduct = new Side((Side) product);
        else newProduct = new Drink((Drink) product);


        ChooseOPtion(newProduct); //세트가 아닌 제품을 고를경우 메뉴 옵션 실행
        if(product instanceof Hamburger){
            Hamburger hamburger = (Hamburger) newProduct; //다운캐스팅을 통해서 Hamburger GetHamburgerSetd이 true인지 아닌지를 판별
            if(hamburger.GetIsburgerSet() == true) newProduct = ComposeSet(hamburger); //만일 세트면 ComposeSet 실행
        }
        Product[] newItems = new Product[items.length + 1]; // 복사하기 위해서는 길이 + 1 추가
        System.arraycopy(items,0,newItems,0,items.length);
        newItems[newItems.length - 1] = newProduct;
        items = newItems;

        System.out.printf("[📣] %s를(을) 장바구니에 담았습니다.\n", newProduct.getName());
    }


    // 선택 옵션
    private void ChooseOPtion(Product product){

        int Input;

            if(product instanceof Hamburger){
                System.out.printf("[System] 단품으로 주문하시겠습니까? (1)_단품(%d원)  (2)_세트(%d원)",
                        product.getPrice(),
                        ((Hamburger) product).getBurgerSetPrice());// 버거 세트의 가격을 읽어들임(getter)
                Input = sc.nextInt();
                if(Input == 2) ((Hamburger) product).setIsburgerSet(true); // 다운캐스팅 : 이미 Product 배열은 업캐스팅이 되어있는 상태이기 때문에 Hambergur의 isHambergurSet을 True로 바꾸귀 위해서는 다운캐스팅을 해야 참조가능하다.
            }
            if(product instanceof Side){
                Side side = (Side) product;
                System.out.println("[System] 케첩은 몇개가 필요하신가요? ");
                Input = sc.nextInt();
                ((Side) product).setIsketchup(Input); // 케첩 개수 할당(개수 수정 setter)
            }
            if(product instanceof Drink){
                Drink drink = (Drink) product;
                System.out.println("[System] 빨대가 필요하십니까? (1)_예  (2)_아니오");
                Input = sc.nextInt();
                if(Input == 2) ((Drink) product).setStraw(false); //??
                }
    }
    // 장바구니 메뉴 화면
    public void CartMenu(){
        System.out.println("🧺 장바구니");
        System.out.println("-".repeat(60));

        printCartItemDetails(); // 장바구니에 담긴 메뉴 출력 메서드

        System.out.println();
        System.out.println("-".repeat(60));
        System.out.printf("합계 : %d원\n",CalculateTotalPrice()); //금액 합계

        System.out.println("이전으로 돌아가려면 엔터를 누르세요."); //엔털를 누를경우 메서드를 빠져나와서 다시 while문으로 순회
        sc.nextLine();
    }


    //장바구니에 담긴 메뉴를 출력하는 메서드
    public void printCartItemDetails(){
        for(Product product : items){
            if(product instanceof HamburgerSet) //HambergurSet에서 참조하기 위해서는 우선 product를 다운캐스팅을 하면 Hamburger의 Side를 참조하고 있는 getSide를 통해 값을 읽어들일수 있으며 Side의 네임과 케첩의 개수를 참조 가능(음료도 같다)
            {
                HamburgerSet hamburgerSet = (HamburgerSet) product;
                System.out.printf("%s %6d원 (%s(케첩 %d개)), %s(빨대 %s)",
                        product.getName(), //햄버거는 왜 다운캐스팅으로 참조를 하지 않을까? : 처음 메뉴를 선택할때 햄버거를 통해서 단품과 세트를 선택할 수 있기때문에 세트는 이미 햄버거의 product 정보를 받게 된다.
                        product.getPrice(),
                        hamburgerSet.getSide().getName(),
                        hamburgerSet.getSide().getIsketchup(),
                        hamburgerSet.getDrink().getName(),
                        hamburgerSet.getDrink().HasStraw() ? "있음" : "없음");
                System.out.println();
            }
            else if(product instanceof Hamburger)
            {
                System.out.printf("%-8s %6d원 (단품)",
                        product.getName(),
                        product.getPrice());
                System.out.println();
            }

            else if(product instanceof Side)
            {
                System.out.printf("%-8s %6d원(케첩 %d)",
                        product.getName(),
                        product.getPrice(),
                        ((Side) product).getIsketchup());
                System.out.println();
            }
            else if(product instanceof Drink){
                System.out.println(System.out.printf("%-8s %6d원(빨대 %s)",
                        product.getName(),
                        product.getPrice(),
                        ((Drink) product).HasStraw() ? "있음" : "없음"));
                System.out.println();
            }
        }
    }

    // ComposeSet : 만약 BurgurSet이면 실행
    private HamburgerSet ComposeSet(Hamburger hamburger)
    {
        int Input;
        System.out.println("[System] 사이드를 골라주세요.");
        menu.SidePrintMenu(false);

        Input = sc.nextInt();
        Side side = (Side) productRepository.FindById(Input);
        Side newside = new Side(side);
        ChooseOPtion(side);

        System.out.println("[System] 음료를 골라주세요.");
        menu.DrinkPrintMenu(false);
        Input = sc.nextInt();
        Drink drink = (Drink) productRepository.FindById(Input);
        Drink newDrink = new Drink(drink); // 매게변수로 Drink drink로 받는다.
        ChooseOPtion(drink);

        String name = hamburger.getName();
        int price = hamburger.getPrice();
        int kcal = hamburger.getKcal() + side.getKcal() + drink.getKcal();

        return new HamburgerSet(name,price,kcal,hamburger,side,drink); //생성자 오버로딩
    }

    protected int CalculateTotalPrice() // 총 가격 메서드
    {
        int totalPrice = 0;
        for(Product product : items){
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
