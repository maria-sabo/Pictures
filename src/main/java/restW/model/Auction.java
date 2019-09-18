package restW.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "auction")
@Getter
@Setter
@ToString
public class Auction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "picture")
    private Picture picture;

    @ManyToOne
    @JoinColumn(name = "seller")
    private Museum seller;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private Museum buyer;

    @Column(name = "cost")
    private BigInteger cost;

    @Column(name = "date")
    private Date date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
    @Column (name = "time_start")
    private Timestamp time_start;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a z")
    @Column (name = "time_end")
    private Timestamp time_end;
}
