import service.AdminService;
import service.ProductService;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        // 1. 스캐너 생성
        Scanner sc = new Scanner(System.in);
        // 2. 서비스하는 객체 생성
        AdminService adminService = new AdminService();
        ProductService productService = new ProductService();

        // 3. 메뉴 번호에 따라 서비스 호출
        while (true) {
            System.out.println("============================================================");
            System.out.println("1. 동전 투입 2. 잔돈 반환 3. 메뉴 선택 4. 관리자 메뉴 5. 종료=>");
            System.out.println("============================================================");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("1. 동전 투입");
                    productService.insertMoney();
                    break;
                case 2:
                    System.out.println("2. 잔돈 반환");
                    //productService.returnMoney();
                    break;
                case 3:
                    System.out.println("3. 메뉴 선택");
                    //productService.buyProduct();
                    break;
                case 4: // 관리자 메뉴
                    adminService.menu();
                    //break;
                case 5:
                    System.out.println("종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

    }
}
