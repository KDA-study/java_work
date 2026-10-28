package autoCar;

public class AutoCarMain {
    static void main(String[] args) {
        AutoCar tico = new AutoCar("티코");
        // 색상지정
        tico.setColor("빨강색");
        tico.speedUP();
        System.out.println("현재 스피드 : "+tico.getSpeed());
        tico.speedDown();
        System.out.println("현재 스피드 : "+tico.getSpeed());
        // 인스턴스의 내부를 출력
        // autoCar.AutoCar@3f99bd52 이런 식으로 보이면
        // 해당 클래스에 가서 toString()을 선언한다.
        System.out.println(tico); // utoCar{carName='티코', color='빨강색', speed=0}
    }
}
