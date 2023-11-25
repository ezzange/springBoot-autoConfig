package hello.member;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
//JdbcTemplate 을 사용해서 회원을 관리하는 리포지토리
@Repository
public class MemberRepository {
    //DbConfig 에서 JdbcTemplate 을 빈으로 등록했기 때문에 바로 주입받아서 사용할 수 있다.
    private final JdbcTemplate template;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        template = jdbcTemplate;
    }
//initTable : 보통 리포지토리에 테이블을 생성하는 스크립트를 두지는 않는다.
//예제를 단순화 하기 위해 이곳에 사용
    public void initTable() {
        template.execute("create table member(member_id varchar primary key, name varchar) ");
    }

    public void save(Member member) {
        template.update("insert into member(member_id, name) values(?,?)",
                member.getMemberId(),
                member.getName());
    }

    public Member find(String memberId) {
        return template.queryForObject(
                "select member_id, name from member where member_id = ? ",
                BeanPropertyRowMapper.newInstance(Member.class),
                memberId);
    }

    public List<Member> findAll() {
        return template.query("select member_id, name from member",
                BeanPropertyRowMapper.newInstance(Member.class));
    }
}
