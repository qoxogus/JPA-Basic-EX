package entity;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import javax.swing.text.TabExpander;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

@Entity
@Getter
@Setter
public class Member extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @ManyToOne  //하나의 팀이 여러명의 멤버를 가질 수 있음
    @JoinColumn(name = "TEAM_ID") //join하는 컬럼은 TEAM_ID  Team을 TEAM_ID로 join
    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
////    @JoinTable(name = "MEMBER_PRODUCT") //테이블 이름이 들어감 연결테이블이 PK가 FK로되는 구조로 생성되어 풀어냄
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String username;



//    private Integer age;
// 
//    @Enumerated(EnumType.STRING) //Enum타입이 ordinal(defualt) -> enum순서(숫자)를 데이터베이스에 저장 / string -> enum이름을 데이터베이스에 저장
//    private entity.RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob //varchar를 넘어서는 큰 컨텐츠가 들어가야 할 컬럼
//    private String description;

    public Member(){
    }

    //연관관계 편의 메서드
    //이것만 호출해도 양쪽으로 값이 다 들어간다
    //원래는 널포인트 체크등 할 일이 많다
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
