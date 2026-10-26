import java.util.Arrays;

public class ArraysEx {
    static void main(String[] args) {
        // scores 배열 선언 : 85, 92, 78, 95, 88, 90
        int[] scores = {85, 92, 78, 95, 88, 90};
        // scores 배열의 값을 하나씩 for 루프를 이용해서 출력
        for (int x : scores) {
            System.out.println(x);
        }
        //scores 배열 전체 한방에 출력하기
        System.out.println(scores); // [I@f6f4d33 : 객체를 식별하는 값
        System.out.println(Arrays.toString(scores));
        // 가장 큰값 찾기
        int max = Arrays.stream(scores).max().orElse(0); // null이면 0 줘
        System.out.println("큰 값 : " + max);

        // 배열을 정렬해 보기
        Arrays.sort(scores); // 원본을 직접 수정해서 정렬
        System.out.println("오름차순 정렬 후 : "+ Arrays.toString(scores));
        // 일반적으로 객체가 갖는 기능
        // 정렬, 찾기, 가장 큰값, 작은값, 출력하기, 복사하기
        // 배열 복사하기
        // 새로운 배열 선언하고 거기에 복사
        int[] copyScores = Arrays.copyOf(scores, scores.length);
        // 복사한 배열을 출력
        System.out.println(Arrays.toString(copyScores));
    }
}
