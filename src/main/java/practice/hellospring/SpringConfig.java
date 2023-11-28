package practice.hellospring;
import org.springframework.beans.factory.annotation.Autowired;
import practice.hellospring.repository.JdbcMemberRepository;
import practice.hellospring.repository.MemberRepository;
import practice.hellospring.repository.MemoryMemberRepository;
import practice.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
// return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}