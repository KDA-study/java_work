package check;

import java.util.Arrays;
import java.util.Scanner;

public class JuminCheck {
    static void main(String[] args) {
        // 주민번호 13자리("-"빼고)를 입력받아서
        // 배열에 쪼개서 저장하고 맞는지 확인하는 프로그램
        // 1. 스캐너 달기
        Scanner scanner = new Scanner(System.in);
        // 2. 주민번호 13자리 입력받기
        System.out.println("주민번호 입력(- 제외) : ");
        // 3. 각 자릿수를 쪼개서 문자열 배열에 넣기
        String[] data = scanner.next().split("");    // regex : 정규 표현식
        //출력
        System.out.println(Arrays.toString(data));
        // 4. for 회전시키면서 문자 -> 숫자배열에 옮길것.
        // 숫자로 변경해서 담을 새 배열 생성
        int[] juminNumber = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            // parsing(파싱) : 특정 값을 다른 값으로 변경하는 기능
            juminNumber[i] = Integer.parseInt(data[i]);
        }
        // 숫자배열값을 출력
        System.out.println(Arrays.toString(juminNumber));
    }
}
