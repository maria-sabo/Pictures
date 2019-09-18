package restW.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "picturemuseum")
@Getter
@Setter
@ToString
public class PictureMuseum extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Picture getPicture(){
        return picture;
    }
    @ManyToOne
    @JoinColumn(name = "picture")
    private Picture picture;

    @ManyToOne
    @JoinColumn(name = "museum")
    private Museum museum;
}
