package service;

import repository.TodoRepository;
import vo.Todo;

import java.util.Scanner;

public class TodoService {
    // 1. 스캐너 생성
    private Scanner sc = new Scanner(System.in);
    // TodoRepository.todos 이용하므로 Todo 타입 인스턴스 생성하지 않음

    // 1. 할 일 등록
    // 할 일 이름과 중요도 입력받아 빈칸에 할 일 등록
    public void addTodo() {
        // 0. 비어있는 칸 있는지 확인
        int emptyIndex = findEmptySlot(); // 비어있는 칸 색인
        if (emptyIndex == -1) {
            System.out.println("더 이상 등록할 수 없습니다. (최대 5개)");
            return;
        }
        System.out.println("[TodoService.addTodo]");
        // 1. 할 일 입력받기
        System.out.println("============= 할 일을 입력하세요 =============");
        String title = sc.next();
        // 2. 같은 할 일이 있으면 return
        // findIndex(title);
        if (findIndex(title) != -1) {
            System.out.println("이미 등록된 할 일입니다.");
            return;
        }

        // 3. 중요도 입력받기
        // 1~3이 아니면 중요도는 1~3만 입력할 수 있습니다.
        System.out.println("==== 할 일의 중요도를 입력하세요(1~3 숫자) ====");
        int priority = sc.nextInt();
        while (priority < 1 || priority > 3) {
            System.out.println("중요도는 1~3만 입력할 수 있습니다.");
            priority = sc.nextInt();
        }

        // 4. todos 빈칸에 할 일 넣고 등록 완료 출력
        Todo myTodo = new Todo(title, priority);
        TodoRepository.todos[emptyIndex] = myTodo;
        System.out.println("등록 완료");

    }

    // 2. 할 일 삭제
    public void deleteTodo() {
        System.out.println("[TodoService.deleteTodo]");
        // todos 다 비어있으면 등록된 할 일이 없습니다.
        // 전체 목록을 보여주고 삭제할 이름 입력받기
        printAll();
        System.out.println("========= 삭제할 할 일을 입력하세요 =========");
        String title = sc.next();
        // 입력받은 할 일이 없으면 없는 할 일입니다.
        // 있으면 return i, 없으면 return -1
        int deleteIndex = findIndex(title);
        if (deleteIndex == -1) {
            System.out.println("없는 할 일입니다.");
            return;
        }
        // 있으면 그 칸을 null로 비우고 삭제 완료 출력
        TodoRepository.todos[deleteIndex] = null;
        System.out.println("삭제 완료");
        printAll();
    }

    // 3. 할 일 수정
    public void updateTodo() {
        System.out.println("[TodoService.updateTodo]");
        printAll();
        // 이름으로 찾은 뒤 이름과 중요도를 새 값으로 덮어쓰기, 중요도 범위 검사는 등록과 같음
        // 완료 여부는 그대로 두기
        System.out.println("========= 수정할 할 일을 입력하세요 =========");
        String title = sc.next();
        // 잘못 입력하면 없는 할 일 출력
        int updateIndex = findIndex(title);
        if (updateIndex == -1) {
            System.out.println("없는 할 일입니다.");
            return;
        }
        System.out.println("========== 새 할 일을 입력하세요 ===========");
        title = sc.next();
        System.out.println("== 새 할 일의 중요도를 입력하세요(1~3 숫자) ==");
        int priority = sc.nextInt();
        while (priority < 1 || priority > 3) {
            System.out.println("중요도는 1~3만 입력할 수 있습니다.");
            priority = sc.nextInt();
        }

        Todo myTodo = new Todo(title, priority);
        TodoRepository.todos[updateIndex] = myTodo;
        System.out.println("수정 완료");

    }

    // 4. 완료 체크
    public void toggleDone() {
        System.out.println("[TodoService.toggleDone]");
        // todos 다 비어있으면 등록된 할 일이 없습니다.
        // 빈칸을 건너뛰고 전체 목록 출력
        printAll();

        // 이름으로 찾은 뒤 완료 여부 뒤집기 (미완료 ↔ 완료)
        System.out.println("완료 여부를 뒤집을 일을 입력하세요 (미완료 ↔ 완료)");
        String title = sc.next();
        // 잘못 입력하면 없는 할 일 출력
        int completeIndex = findIndex(title);
        if (completeIndex == -1) {
            System.out.println("없는 할 일입니다.");
            return;
        }
        boolean done = TodoRepository.todos[completeIndex].isDone() ? false : true;
        TodoRepository.todos[completeIndex].setDone(done);
        if (done) {
            System.out.println(TodoRepository.todos[completeIndex].getTitle() + " → 완료");
        } else {
            System.out.println(TodoRepository.todos[completeIndex].getTitle() + " → 미완료");
        }
    }

    // 5. 전체 목록
    public void printAll() {
        System.out.println("[TodoService.printAll]");
        // todos 다 비어있으면 출력할 목록 없음
        if (isEmpty()) {
            System.out.println("등록된 할 일이 없습니다.");
            return;
        }
        // 빈칸을 건너뛰고 전체 목록 출력
        System.out.println("======== 할 일 목록 ========");
        for (int i = 0; i < TodoRepository.todos.length; i++) {
            if (TodoRepository.todos[i] == null) {
                continue;
            }
            System.out.println(TodoRepository.todos[i]);
        }
        System.out.println("===========================");
    }

    // 6. 남은 할 일
    // 미완료만 출력하고 개수 출력
    public void printRemain() {
        System.out.println("[TodoService.printRemain]");
        System.out.println("===== 남은 할 일 목록 =====");
        int count=0;
        for (int i = 0; i < TodoRepository.todos.length; i++) {
            if (TodoRepository.todos[i] == null) {
                continue;
            }
            if (TodoRepository.todos[i].isDone() == false) {
                System.out.println(TodoRepository.todos[i].toString());
                count += 1;
            }
        }
        System.out.println("남은 할 일 : " + count + "개");
        System.out.println("=========================");
    }

    // 같은 할 일 이름의 칸 번호
    // 없으면 -1
    private int findIndex(String title) {
        System.out.println("[TodoService.findIndex]");
        for (int i = 0; i < TodoRepository.todos.length; i++) {
            if (TodoRepository.todos[i] == null) {
                continue;
            }
            if (TodoRepository.todos[i].getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    // null 첫 칸 번호
    // 없으면 -1
    private int findEmptySlot() {
        System.out.println("[TodoService.findEmptySlot]");
        for (int i = 0; i < TodoRepository.todos.length; i++) {
            if (TodoRepository.todos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    // todos 다 비어있는지?
    // 할 일 하나도 없으면 true
    private boolean isEmpty() {
        System.out.println("[TodoService.isEmpty]");
        for (int i = 0; i < TodoRepository.todos.length; i++) {
            if (TodoRepository.todos[i] != null) {
                return false;
            }
        }
        return true;
    }

}
