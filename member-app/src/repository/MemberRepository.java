package repository;

import entity.Member;

// 모든 CRUD 구현의 뼈대를 갖는 클래스
// 시킬 때는 줄 것과 받을 것 명시
public interface MemberRepository {
    // 1. 저장
    // public abstract 리턴타입 save(줄거);
    // public abstract boolean save(Member member);
    // 내가 멤버를 줄테니 저장은 너가 알아서 하고
    // 결과(true/false)만 리턴해
    boolean save(Member member); // public abstract 생략

    // 2. 전체 읽어서 멤버 객체 배열로 리턴
    Member[] findAll();

    // 3. 특정 아이디를 찾는 기능 (모든 기준은 PK)
    // id 받아서 있으면 true, 없으면 false
    boolean findByID(int id);

    // 4. 수정
    // 수정할 멤버를 받아서 수정처리
    // 수정 후 성공 : true, 실패 : false
    boolean update(Member member);

    // 5. 삭제
    boolean deleteById(int id);
}
