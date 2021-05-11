package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable //값 타입을 정의하는곳에 표시하는 어노테이션
@Getter
@Setter
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
