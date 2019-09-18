package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "genre")
@Getter
@Setter
@ToString
public class Genre extends BaseEntity {
    @Column(name = "name")
    private String name;
}
