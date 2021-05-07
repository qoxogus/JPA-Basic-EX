package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    private String createBy;
    private LocalDateTime createDate;
    private String lastmodifiedBy;
    private LocalDateTime lastModifiedDate;
}
