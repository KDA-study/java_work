public class SnackShop {
    // 김밥, 떡볶이, 순대 가격 만들기
    static final int KIMBAP = 3000;
    static final int TTEOKBOKKI = 3500;
    static final int SUNDAE = 4000;

    // 문제 1
    public void printWelcome() {
        System.out.println("=== 김떡순 분식에 오신 것을 환영합니다! ===");
    }

    // 문제 2
    public int calcKimbap(int count) {
        return count * KIMBAP;
    }
    public int calcTteokbokki(int count) {
        return count * TTEOKBOKKI;
    }
    public int calcSundae(int count) {
        return count * SUNDAE;
    }

    // 문제 3
    public int order(int x) {
        return x * KIMBAP;
    }
    public int order(int x, int y) {
        return (x * KIMBAP) + (y * TTEOKBOKKI);
    }
    public int order(int x, int y, int z) {
        return (x * KIMBAP) + (y * TTEOKBOKKI)+(z*SUNDAE);
    }

    // 문제 4
    public int discount(int money) {
        return (int) (money * 0.9);
    }
    public int discount(int money, double ratio) {
        return (int) (money * (1-ratio));
    }
    public int discount(int money, String isVIP) {
        if (isVIP == "VIP") {
            return (int) (money * 0.7);
        } else {
            return money;
        }
    }
}
