package mystudy.demo.repository;

import mystudy.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
@AfterEach
public void afterEach(){
repository.clearStore();
}
    @Test
    public void save() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        repository.save(member);
        //then
        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("seongmin");
        repository.save(member2);
        Member result2 = repository.findByName("seongmin").get();
        assertThat(result2).isEqualTo(member2);
    }
    @Test
    public void findAll (){
       Member member1 = new Member();
       member1.setName("A");
       repository.save(member1);

        Member member2 = new Member();
        member1.setName("B");
        repository.save(member2);

        Member member3 = new Member();
        member1.setName("C");
        repository.save(member3);


        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(3);

    }

}
