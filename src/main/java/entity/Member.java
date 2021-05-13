package entity;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import javax.swing.text.TabExpander;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVIRITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//        @JoinColumn(name = "MEMBER_ID")
//    )
//    private List<Address> addressHistory = new ArrayList<>();
    @OneToMany(cascade = ALL, orphanRemoval = true) //값타입 컬렉션 대안 (일대다 관계를 고려하라) (영속성전이(cascade) + 고아객체 제거를 사용해서 값타입 컬렉션처럼 사용
    @JoinColumn(name = "MEMBER_ID") //일대다 단방향 매핑
    private List<AddressEntity> addressHistory = new ArrayList<>();

//    //기간 Period
//    @Embedded //값 타입을 사용하는곳에 표시하는 어노테이션
//    private Period workPeriod;
////    private LocalDateTime startDate;
////    private LocalDateTime endDate;
//
//    //주소
//    @Embedded
//    private Address homeAddress;
//    private String city;
//    private String street;
//    private String zipcode;

//    @ManyToOne(fetch = FetchType.LAZY)  //하나의 팀이 여러명의 멤버를 가질 수 있음
//    @JoinColumn(name = "TEAM_ID") //join하는 컬럼은 TEAM_ID  Team을 TEAM_ID로 join
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
////    @JoinTable(name = "MEMBER_PRODUCT") //테이블 이름이 들어감 연결테이블이 PK가 FK로되는 구조로 생성되어 풀어냄
//    private List<MemberProduct> memberProducts = new ArrayList<>();

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
