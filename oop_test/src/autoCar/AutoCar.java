package autoCar;

public class AutoCar {
    // 멤버선언
    private String carName;
    private String color;
    private int speed;

    // 1. carName은 생성자로 받는다.
    public AutoCar() {} // 디폴트 생성자

    public AutoCar(String carName) {
        this.carName = carName;
    }


    // 2. Getter와 Setter 만든다.

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }


    public String getCarName() {
        return carName;
    }

    // speedUp
    public void speedUP() {
        if(speed<=40) this.speed = this.speed + 10;
    }

    // speedDown
    public void speedDown() {
        if(speed>0) this.speed = this.speed - 10;
    }

    @Override
    public String toString() {
        return "AutoCar{" +
                "carName='" + carName + '\'' +
                ", color='" + color + '\'' +
                ", speed=" + speed +
                '}';
    }
}
