public class Example {
    static void main(String[] args) {
        String str = "information!";
        int n = str.length();    // length() 메소드는 해당 문자열의 길이를 반환(12)
        char[] st = new char[n];    // 배열도 클래스이므로 생성할 때 new 사용
        n--;    // n = 11

        for (int k = n; k >= 0; k--) {    // 반복변수 k는 for문 안에서 선언한 지역변수 -> for문을 벗어나면 소멸
            st[n - k] = str.charAt(k);    // charAt() 메소드는 해당 문자열(str)에서 인수에 해당하는 위치의 문자열 반환
        }
        for (char k : st) {    // 향상된 반복문, st 배열의 각 요소를 처음부터 차례대로 k에 옮김
            System.out.printf("%c", k);    // k에는 st 배열 각 요소의 값이 할당되므로 12회 수행
        }
    }
}
