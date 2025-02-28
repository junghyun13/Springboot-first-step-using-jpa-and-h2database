package hello.hello_spring;

import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(@Qualifier("memoryMemberRepository") MemberRepository memberRepository/*MemberRepository memberRepository*/){
        this.memberRepository = memberRepository;
    }
    /*private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }*/
    /*private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
    /*@Bean
    public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/
}