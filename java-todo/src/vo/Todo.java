package vo;

public class Todo {
    private String title;
    private int priority;
    private boolean done;

    // 생성자 만들기
    public Todo(String title, int priority) {
        this.title = title;
        this.priority = priority;
        this.done = false;
    }

    // title : Getter, Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // priority : Getter, Setter
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // done : Getter, Setter
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // 클래스 내부 출력
    @Override
    public String toString() {
        if (done) {
            return "[V] " + title + " / 중요도 : " + priority;
        } else {
            return "[ ] " + title + " / 중요도 : " + priority;
        }
    }
}
