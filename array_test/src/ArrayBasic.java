public class ArrayBasic {
    static void main(String[] args) {
        // 배열을 선언
        // 1. 정수형 배열
        // 배열 변수를 선언함과 동시에 초기화 하는 방법
        int[] scores = {85, 92, 78, 95, 88, 90};
        // 배열의 크기만 정하고 초기화 하기
        int[] values = new int[6]; // 6개 생성 (인덱스 X), new -> 객체 생성
        System.out.println("values의 0번째 : " + values[0]); // 결과 - values의 0번째 : 0

        // 2. 문자열 배열
        String[] members = {"홍길동", "이순신", "김유신"};
        // 배열 공간만 미리 만들기
        String[] team = new String[5]; // 5개의 문자열 배열만 선언
        // 모든 객체(대문자로 시작)의 초기값 : null 값을 갖는다.
        // null : 존재하는데 확인이 안 됨
        // 팀의 1번째 있는 요소 출력
        System.out.println("team 첫번째 : " + team[0]); // 결과 - team 첫번째 : null
        if (team[0] == "") {    // 결과 - 같지 않다, null인지 비교
            System.out.println("같다");
        } else {
            System.out.println("같지 않다");
        }

        // 3. 실수형 배열
        double[] data = {0.2, 1.3, 3.1};
        System.out.println(data[1]);

        // members 배열의 길이 출력
        System.out.println("members 배열의 길이 : "+members.length); // .length : () 없는 건 값, 있는 건 동작

    }
}
