package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Examresult domain object
 */
@Entity
public class ExamResult extends BaseEntity {

    @Column(name = "prufungsDatum")
    @Temporal(TemporalType.DATE)
    private Date examDate;

    private int mark;

    @Transient
    private String examLocation;


    //Getter and setters omitted

}
