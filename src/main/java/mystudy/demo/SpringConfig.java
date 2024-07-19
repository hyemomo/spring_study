package mystudy.demo;

import mystudy.demo.repository.MemberRepository;
import mystudy.demo.repository.MemoryMemberRepository;
import mystudy.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    };
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
