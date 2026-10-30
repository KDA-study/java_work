import service.TodoService;

import java.util.Scanner;

public class Main {
    static void main() {
        // 1. Todo 서비스하는 객체 생성
        TodoService todoService = new TodoService();

        // 2. 스캐너 생성
        Scanner sc = new Scanner(System.in);

        // 3. while 구문 메뉴 반복 출력
        // 1.할 일 등록 2.할 일 삭제 3.할 일 수정 4.완료 체크 5.전체 목록 6.남은 할 일 7.종료=>
        while (true) {
            System.out.println("================================================================================");
            System.out.println("1.할 일 등록 2.할 일 삭제 3.할 일 수정 4.완료 체크 5.전체 목록 6.남은 할 일 7.종료=>");
            System.out.println("================================================================================");
            // 4. 메뉴 번호 입력 받은 후 switch로 분기
            int menu = sc.nextInt();
            switch (menu) {
                case 1: // 1.할 일 등록
                    // System.out.println("1.할 일 등록");
                    todoService.addTodo();
                    break;
                case 2: // 2.할 일 삭제
                    // System.out.println("2.할 일 삭제");
                    todoService.deleteTodo();
                    break;
                case 3: // 3.할 일 수정
                    // System.out.println("3.할 일 수정");
                    todoService.updateTodo();
                    break;
                case 4: // 4.완료 체크
                    // System.out.println("4.완료 체크");
                    todoService.toggleDone();
                    break;
                case 5: // 5.전체 목록
                    // System.out.println("5.전체 목록");
                    todoService.printAll();
                    break;
                case 6: // 6.남은 할 일
                    // System.out.println("6.남은 할 일");
                    todoService.printRemain();
                    break;
                case 7: // 종료=>
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
