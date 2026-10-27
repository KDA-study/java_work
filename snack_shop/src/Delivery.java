public class Delivery {
    public int deliveryFee(int distance) {
        if (distance <= 2) {
            return 2000;
        } else {
            return 2000 + ((distance - 2) * 500);
        }
    }

    public int deliveryFee(int distance, boolean rain) {
        if (rain) {
            return deliveryFee(distance) + 1000;
        } else {
            return deliveryFee(distance);
        }
    }
}
