package App;

import App.Product.ProductRepository;

import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);

    private ProductRepository productRepository;
    private Menu menu;
    private Cart cart;
    private  Order order;

    public Kiosk(ProductRepository productRepository, Menu menu, Cart cart, Order order) {
        this.productRepository = productRepository;
        this.menu = menu;
        this.cart = cart;
        this.order = order;
    }


    public void operator() // 실행 파일
    {
        while (true) {
            menu.printMenu();
            String input = sc.nextLine();

            if (input.equals("+")) {
                order.makeOrder();
                break;
            } else {
                int members = Integer.parseInt(input);
                if (input.equals("0")) cart.CartMenu(); //0번일 경우 장바구니 담긴내역 출력
                else if (members >= 1 && members <= productRepository.getProduct().length) cart.addToCart(members); // 만일 주문하는 목록중에 입력값이 있다면 실행
                else System.out.println("잘못된 입력값입니다 다시 입력해주십시오.");
            }
        }
    }
}
