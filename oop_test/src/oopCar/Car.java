package oopCar;

// 자동차 객체(변수와 메서드)를 정의하는 클래스
public class Car {
    // 멤버변수에 private -> 외부에서 보이는 걸 차단
    // 캡슐화
    // 멤버변수를 변경할 때는 반드시 메서드를 통해서 변경
    // 멤버는 다 private, 메서드는 다 public
    private String brand; // 자동차의 회사
    private String carName; // 브랜드
    private String color; // 색상
    private int speed; // 현재 자동차의 속도

    public String getBrand() {
        return brand;
    }

    public String getCarName() {
        return carName;
    }

    // color를 외부에서 읽거나, 수정 가능하게
    // 1. Getter(외부에서 읽기 가능)-Read
    public String getColor() {
        return this.color;
    }

    // 2. Setter(외부에서 수정 가능)-Update
    public void setColor(String color) {
        this.color = color;
    }


    // 모든 객체는 기본 생성자를 갖는다.
    // 기본 생성자는 자동으로 만들어진다
    public Car() {
        System.out.println("나는 기본 생성자에요");
    }

    // 내가 원하는 생성자를 만든다.
    // 생성자 오버로딩
    // this -> 나 자신
    public Car(String brand, String carName) {
        this.brand = brand;
        this.carName = carName;
    }

    // 기능(메서드)
    // 속도 증가(10씩)
    public void speedUP() {
        // 최고 속도 50km
        if (speed >= 50) {
            System.out.println("최고 속도에요");
        } else {
            speed = speed + 10;
        }
    }
    // 속도 감소(10씩)
    public void speedDown() {
        if (speed == 0) {
            System.out.println("자동차가 멈췄어요");
        } else {
            speed = speed - 10;
        }
    }

    // 현재 속도 출력
    public int currentSpeed() {
        return speed;
    }

    // 내차 정보 출력하기
    public void myCarInfo() {
        System.out.println(brand + " / "+carName+" / "+color);
    }

}
