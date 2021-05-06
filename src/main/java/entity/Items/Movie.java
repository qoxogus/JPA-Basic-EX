package entity.Items;

import entity.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("M") //DTYPE value이름을 정해주는 어노테이션
public class Movie extends Item {

    private String director;
    private String actor;
}
