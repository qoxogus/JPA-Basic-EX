package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team") //하나의 Team은 여러명의 Member를 가질 수 있음  mappedBy -> 나는 뭐랑 연결되어있지? -> Member에 있는 Team의 변수명 (나는 team으로 매핑이 되어있는 컬럼이다)
    private List<Member> members = new ArrayList<>(); //ArrayList로 초기화 해두는게 관례이다(조회할 때 NullPoint가 안뜸)
}
