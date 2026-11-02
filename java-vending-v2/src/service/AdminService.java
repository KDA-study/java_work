package service;

import repository.VendingRepository;
import vo.Product;

import java.util.Scanner;

public class AdminService {
    // 관리자 기능: 등록, 삭제, 수정, 재고 등록

    // 1. 스캐너 생성
    private Scanner sc = new Scanner(System.in);

    // 2. new ProductService()로 객체를 만들어 printAll, findIndex, isEmpty를 함께 씁니다.
    private ProductService productService = new ProductService();

    // 관리자 메뉴를 6번(이전)을 고를 때까지 반복
    public void menu() {
        while (true) {
            System.out.println("====================================================================");
            System.out.println("1.메뉴 등록 2.메뉴 삭제 3.메뉴 수정 4. 재고 등록 5. 전체목록보기 6. 이전=>");
            System.out.println("====================================================================");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
//                    System.out.println("1. 메뉴 등록");
                    addProduct();
                    break;
                case 2:
//                    System.out.println("2. 메뉴 삭제");
                    deleteProduct();
                    break;
                case 3:
//                    System.out.println("3. 메뉴 수정");
                    updateProduct();
                    break;
                case 4:
//                    System.out.println("4. 재고 등록");
                    addStock();
                    break;
                case 5:
//                    System.out.println("5. 전체목록보기");
                    productService.printAll();
                    break;
                case 6: // return으로 메서드를 끝내 메인 메뉴로 돌아감.
                    System.out.println("메인 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }

        }
    }

    // 빈칸에 새 상품 등록 (최대 3개, 중복 이름 불가)
    public void addProduct() {
        System.out.println("[AdminService.addProduct()]");
        int emptyIndex = findEmptySlot();
        if (emptyIndex == -1) {
            System.out.println("더 이상 등록할 수 없습니다. (최대 3개)");
            return;
        }
        System.out.println("==== 제품의 이름을 입력하세요. ====");
        String name = sc.next();

        if (productService.findIndex(name) != -1) {
            System.out.println("이미 등록된 제품입니다.");
            return;
        }

        System.out.println("==== 제품의 가격을 입력하세요. ====");
        int price = sc.nextInt();
        System.out.println("==== 제품의 재고를 입력하세요. ====");
        int stock = sc.nextInt();

        // Product 타입 생성
        Product p = new Product(name, price, stock);
        VendingRepository.products[emptyIndex] = p;


    }

    // 제품명을 입력받아 그 칸을 null로 비우기
    public void deleteProduct() {
        System.out.println("[AdminService.deleteProduct()]");
        if (productService.isEmpty()) {
            System.out.println("현재 자판기에 상품이 없습니다.");
            return;
        }
        // 제품 목록 보여주기
        productService.printAll();
        System.out.println("==== 삭제할 제품의 이름을 입력하세요. ====");
        String name = sc.next();

        int productIndex = productService.findIndex(name);
        if (productIndex == -1) {
            System.out.println("없는 제품입니다.");
            return;
        }

        VendingRepository.products[productIndex] = null;


    }

    // 이름, 가격, 재고를 새 값으로 덮어쓰기
    public void updateProduct() {
        System.out.println("[AdminService.updateProduct()]");
        if (productService.isEmpty()) {
            System.out.println("현재 자판기에 상품이 없습니다.");
            return;
        }
        // 제품 목록 보여주기
        productService.printAll();
        System.out.println("==== 수정할 제품의 이름을 입력하세요. ====");
        String name = sc.next();

        int productIndex = productService.findIndex(name);
        if (productIndex == -1) {
            System.out.println("없는 제품입니다.");
            return;
        }

        System.out.println("==== 제품의 새 이름을 입력하세요. ====");
        String newName = sc.next();
        VendingRepository.products[productIndex].setName(newName);

        System.out.println("==== 제품의 새 가격을 입력하세요. ====");
        int newPrice = sc.nextInt();
        VendingRepository.products[productIndex].setPrice(newPrice);

        System.out.println("==== 제품의 새 재고를 입력하세요. ====");
        int newStock = sc.nextInt();
        VendingRepository.products[productIndex].setStock(newStock);
    }

    // 입력한 수량을 기존 재고에 더하기
    public void addStock() {
        System.out.println("[AdminService.addStock()]");
        if (productService.isEmpty()) {
            System.out.println("현재 자판기에 상품이 없습니다.");
            return;
        }
        // 제품 목록 보여주기
        productService.printAll();
        System.out.println("==== 재고를 더할 제품의 이름을 입력하세요. ====");
        String name = sc.next();

        int productIndex = productService.findIndex(name);
        if (productIndex == -1) {
            System.out.println("없는 제품입니다.");
            return;
        }

        System.out.println("==== 더할 재고를 숫자로 입력하세요. ====");
        int addStock = sc.nextInt();
        addStock = VendingRepository.products[productIndex].getStock() + addStock;
        VendingRepository.products[productIndex].setStock(addStock);
    }

    // 비어 있는(null) 첫 칸 번호, 없으면 -1 (등록할 때만 사용)
    private int findEmptySlot() {
        System.out.println("[AdminService.findEmptySlot()]");
        for (int i = 0; i < VendingRepository.products.length; i++) {
            if (VendingRepository.products[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
