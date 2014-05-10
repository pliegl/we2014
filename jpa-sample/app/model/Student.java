package model;

import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Student domain class
 */
@Entity
public class Student extends BaseEntity {

    @Column(name = "matrikelNummer", unique = true)
    private String registrationNumber;

    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Scholarship scholarship;

    @Transient
    private DateTime loginTime;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(DateTime loginTime) {
        this.loginTime = loginTime;
    }

    public Scholarship getScholarship() {
        return scholarship;
    }

    public void setScholarship(Scholarship scholarship) {
        this.scholarship = scholarship;
    }
}
