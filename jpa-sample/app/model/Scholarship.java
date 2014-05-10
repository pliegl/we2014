package model;

import javax.persistence.*;

/**
 * Created by pl on 10.05.14.
 */
@Entity
public class Scholarship extends BaseEntity {

    private String description;

    private Integer amount;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Student grantedTo;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Student getGrantedTo() {
        return grantedTo;
    }

    public void setGrantedTo(Student grantedTo) {
        this.grantedTo = grantedTo;
    }
}
