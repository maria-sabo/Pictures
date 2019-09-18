package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "picture")
@Getter
@Setter
@ToString
public class Picture extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setById(Integer ident) {
        this.id = ident;
    }
}
