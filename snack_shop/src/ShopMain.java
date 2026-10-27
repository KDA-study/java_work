public class ShopMain {
    public static void main(String[] args) {
        SnackShop shop = new SnackShop();
        Delivery delivery = new Delivery();

        // 문제 1
        shop.printWelcome();

        // 문제 2
        System.out.println(shop.calcKimbap(2));
        System.out.println(shop.calcTteokbokki(3));
        System.out.println(shop.calcSundae(1));

        // 문제 3
        System.out.println(shop.order(2));
        System.out.println(shop.order(2, 1));
        System.out.println(shop.order(2, 1, 1));

        // 문제 4
        System.out.println(shop.discount(10000));
        System.out.println(shop.discount(10000, 0.2));
        System.out.println(shop.discount(10000, "VIP"));
        System.out.println(shop.discount(10000, "일반"));

        // 문제 6
        System.out.println(delivery.deliveryFee(1));
        System.out.println(delivery.deliveryFee(5));
        System.out.println(delivery.deliveryFee(5, true));
        System.out.println(delivery.deliveryFee(5, false));

        // 최종 결제
        int foodPrice = shop.order(2, 1, 1);
        int salePrice = shop.discount(foodPrice, "VIP");
        int fee = delivery.deliveryFee(5, true);
        int finalPrice = salePrice + fee;
        System.out.println("최종 결제 금액: " + finalPrice + "원");
    }
}