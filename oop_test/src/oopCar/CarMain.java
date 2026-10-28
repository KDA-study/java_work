package oopCar;
// 자동차 생성하고 사용하는 클래스
public class CarMain {
    static void main(String[] args) {
        // 차를 구매
        Car myCar = new Car();
        Car k7 = new Car("기아", "K7");
        k7.setColor("흰색");
        k7.myCarInfo();

//        myCar.brand = "현대";
//        myCar.carName = "소나타";
//        myCar.color = "빨강";
        myCar.myCarInfo();

        // for 루프로 10번 스피드업하기
        for (int i = 1; i <= 10; i++) {
            myCar.speedUP();
            System.out.println("현재 속도 : "+myCar.currentSpeed()+"km");
        }

        // myCar.speed = 300; // 변경하면 안 됨

        // for 루프로 10번 스피드 줄이기
        for (int i = 1; i <= 10; i++) {
            myCar.speedDown();
            System.out.println("현재 속도 : "+myCar.currentSpeed()+"km");
        }
    }
}
