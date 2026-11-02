package repository;

import vo.Product;

public class VendingRepository {
    // 공용 데이터 (static): 상품 배열(products), 잔액(balance)
    public static Product[] products = new Product[3];
    public static int balance = 0;

}
