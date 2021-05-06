package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED) //조인전략 선택 어노테이션
@DiscriminatorColumn   //DTYPE 엔티티명이 들어가게됨 왠만하면 넣어두는게 좋다 (이름지정가능)
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
