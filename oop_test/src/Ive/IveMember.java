package Ive;
// 아이브 각 멤버를 규정할 설계도
// 모양만 잡는다.
// 이름, 나이, 포지션
public class IveMember {
    // IveMember클래스의 멤버변수
    String name;
    int age;
    String position;

    // IveMember클래스의 메서드
    void printInfo() {
        System.out.println(name+"/"+age+"/"+position);
    }
}
