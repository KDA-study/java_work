package Ive;

public class IveMain {
    static void main(String[] args) {
        // 아이브 멤버를 생성
        IveMember jang = new IveMember();
        jang.name = "장원영";
        jang.age = 22;
        jang.position = "비주얼";
        jang.printInfo();
    }
}
