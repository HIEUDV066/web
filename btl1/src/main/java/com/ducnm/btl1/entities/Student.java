package com.ducnm.btl1.entities;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotBlank(message = "Id không được để trống")
    private String id;
    @Column(name = "name")
    @NotBlank(message = "Tên không được để trống")
    private String name;
    @Column(name = "dob")
    @NotNull(message = "dob không được để trống")
    private Date dob;
    @Column(name = "major")
    @NotBlank(message = "major không được để trống")
    private String major;
    @Column(name = "vaccinated")
    private boolean vaccinated;

    public Student() {
    }

    public Student(String id, String name, Date dob, String major, boolean vaccinated) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.major = major;
        this.vaccinated = vaccinated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
