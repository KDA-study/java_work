package vo;

public class Product {
    // 상품 한 개의 정보
    private String name;    // 제품명
    private int price;    // 가격
    private int stock;    // 재고 개수

    // 생성자 만들기
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // 모든 필드 getter/setter, 생성자로 값을 받음
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // 클래스 내부 출력
    @Override
    public String toString() {
        return "제품명 : " + name + " / 가격 : " + price + " / 재고 개수 : " + stock;
    }
}
