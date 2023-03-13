package App;

import App.Product.Product;
import App.Product.SubProduct.Drink;
import App.Product.SubProduct.Hamburger;
import App.Product.SubProduct.Side;

public class Menu {

    Product[]products;

    public Menu(Product[] products){
        this.products = products;
    }

    public void printMenu(){
        System.out.println("[안내] \uD83C\uDF54 MC Donald에 오신것을 환영합니다.");
        System.out.println("[\uD83D\uDD3B] Mc Donald 메뉴 입니다.");
        System.out.println("-".repeat(50));

        HambergerPrintMenu(true);
        SidePrintMenu(true);
        DrinkPrintMenu(true);

        System.out.println();
        System.out.println("🧺 (0) 장바구니");
        System.out.println("📦 (+) 주문하기");
        System.out.println("-".repeat(60));
        System.out.print("[📣] 메뉴를 선택해주세요 : ");

    }


    protected void DrinkPrintMenu(boolean print) {
        System.out.println("[System] \uD83E\uDD64 음료");
        System.out.println("-".repeat(50));
        for(Product product : products){
            if(product instanceof Drink){
                PrintEachMenu(product,print);
            }
        }
    }

    protected void SidePrintMenu(boolean print) {
        System.out.println("[System] \uD83C\uDF5F 사이드");
        System.out.println("-".repeat(50));
        for(Product product : products){
            if(product instanceof Side){
                PrintEachMenu(product,print);
            }
        }
    }

    private void HambergerPrintMenu(boolean print) {
        System.out.println("[System] \uD83C\uDF54 햄버거");
        System.out.println("-".repeat(50));
        for(Product product : products){
            if(product instanceof Hamburger){
                PrintEachMenu(product,print);
            }
        }
    }

    private static void PrintEachMenu(Product product,boolean print) {
        if(print == true) {
            System.out.printf("(%d) %s  %5d(Kcal)  %5d(원)",
                    product.getId(),
                    product.getName(),
                    product.getKcal(),
                    product.getPrice());
            System.out.println("");
        }
        else {
            System.out.printf("(%d) %s  %5d(Kcal)",
                    product.getId(),
                    product.getName(),
                    product.getKcal());
            System.out.println("");
        }
    }
}
