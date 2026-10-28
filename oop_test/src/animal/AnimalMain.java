package animal;

public class AnimalMain {
    static void main(String[] args) {
        // 강아지 - 푸들, 쫑이, 3세
        Dog jjong = new Dog();
        jjong.jong = "푸들";
        jjong.name = "쫑이";
        jjong.age = 3;
        jjong.sound();

        // 고양이 - 자부종, 냥이, 2세
        Cat cat = new Cat();
        cat.jong = "자부종";
        cat.name = "냥이";
        cat.age = 2;
        cat.sound();



    }
}
