package service;

import repository.VendingRepository;
import vo.Product;

import java.util.Scanner;

public class ProductService {
    // 사용자 기능: 동전 투입, 잔돈 반환, 구매 + 공통 도우미

    // 1. 스캐너 생성
    private Scanner sc = new Scanner(System.in);

    // 2. 동전 투입, 잔액에 더하고 출력
    public void insertMoney() {
        System.out.println("============ 동전을 투입하세요. ============");
        System.out.println("1: 5,000원, 2: 1,000원, 3: 500원, 4: 100원");
        int menu = sc.nextInt();

        switch (menu) {
            case 1:
                VendingRepository.balance = VendingRepository.balance + 5000;
                System.out.println("잔액 : %,d".formatted(VendingRepository.balance));
                break;
            case 2:
                VendingRepository.balance = VendingRepository.balance + 1000;
                System.out.println("잔액 : %,d".formatted(VendingRepository.balance));
                break;
            case 3:
                VendingRepository.balance = VendingRepository.balance + 500;
                System.out.println("잔액 : %,d".formatted(VendingRepository.balance));
                break;
            case 4:
                VendingRepository.balance = VendingRepository.balance + 100;
                System.out.println("잔액 : %,d".formatted(VendingRepository.balance));
                break;
        }
    }

    // 3. 잔돈 반환, 잔액을 출력하며 반환하고 0으로 만들기
    public void returnMoney() {
        System.out.println("잔액 : %,d원을 반환합니다.".formatted(VendingRepository.balance));
        VendingRepository.balance = 0;
    }

    // 4. 구매, 제품명을 입력받아 4단계 검사 후 잔액 차감, 재고 1 감소
    public void buyProduct() {
        // 1. 상품이 하나도 없음.
        if (isEmpty()) {
            System.out.println("현재 자판기에 상품이 없습니다.");
            return;
        }

        // 2. 입력한 제품명이 없음.
        System.out.println("==== 구매할 제품을 입력하세요. ====");
        String name = sc.next();
        int productIndex = findIndex(name);
        if (productIndex == -1) {
            System.out.println("없는 제품입니다.");
            return;
        }

        // 3. 재고가 0
        if (VendingRepository.products[productIndex].getStock() == 0) {
            System.out.println("품절입니다.");
            return;
        }

        // 4. 잔액 < 가격
        if (VendingRepository.balance < VendingRepository.products[productIndex].getPrice()) {
            System.out.println("금액이 부족합니다. 사용 가능 금액 : %,d".formatted(VendingRepository.balance));
            return;
        }

        // 모두 통과하면 잔액에서 가격을 빼고 재고를 1 줄인 뒤 출력
        VendingRepository.balance = VendingRepository.balance - VendingRepository.products[productIndex].getPrice();
        int remainStock = VendingRepository.products[productIndex].getStock() - 1;
        VendingRepository.products[productIndex].setStock(remainStock);
        System.out.println("%s 출력 완료, 남은 돈 : %,d, 재고 : %d".formatted(VendingRepository.products[productIndex].getName(), VendingRepository.balance, VendingRepository.products[productIndex].getStock()));

    }

    // 5 ~ 7. 공통 도우미, AdminService도 사용
    // 5. 빈칸을 건너뛰고 전체 목록 출력
    public void printAll() {
        System.out.println("[ProductService.printAll]");
        for (int i = 0; i < VendingRepository.products.length; i++) {
            if (VendingRepository.products[i] == null) {
                continue;
            }
            System.out.println(VendingRepository.products[i].toString());
        }
    }

    // 6. 같은 제품명의 칸 번호, 없으면 -1
    public int findIndex(String name) {
        System.out.println("[ProductService.findIndex]");
        for (int i = 0; i < VendingRepository.products.length; i++) {
            if (VendingRepository.products[i] == null) {
                continue;
            }
            if (VendingRepository.products[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    // 7. 상품이 하나도 없으면 true
    public boolean isEmpty() {
        System.out.println("[ProductService.isEmpty]");
        for (int i = 0; i < VendingRepository.products.length; i++) {
            if (VendingRepository.products[i] != null) {
                return false;
            }
        }
        return true;

    }




}
