package restW.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "offers")
@Getter
@Setter
@ToString
public class Offers extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cost")
    long cost;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private Museum buyer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
    @Column(name = "time")
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "auction")
    private Auction auction;
}


