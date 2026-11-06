package repository;

import entity.Member;

public class ArrayMemberRepository implements MemberRepository{
    // Member 담을 배열 10개 선언
    private Member[] members = new Member[10];
    // 현재 배열에 저장된 갯수
    private int count = 0;
    // 다음에 넣을 id 값 생성하기 - auto_increment
    private int nextId = 1;

    @Override
    public boolean save(Member member) {
        System.out.println("[ArrayMemberRepository.save()]");
        System.out.println(member);
        // 배열 갯수 10개 넘었는지 확인
        if (count == members.length) {
            return false;
        }
        // id를 셋팅
        member.setId(nextId);
        nextId++;
        // count번째 저장
        members[count]=member;
        count++;

        // 잘 저장됐는지 찍어보기
//        for (Member x : members) {
//            System.out.println(x);
//        }
        return true;
    }

    @Override
    public Member[] findAll() {
        // count 크기의 새 배열 생성
        Member[] newMembers = new Member[count];

        for (int i = 0; i < count; i++) {
            newMembers[i] = members[i];
        }
        return newMembers;
    }

    @Override
    public boolean findByID(int id) {
        for (int i = 0; i < count; i++) {
            if (members[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean update(Member member) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
