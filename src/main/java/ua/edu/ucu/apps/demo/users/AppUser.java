package ua.edu.ucu.apps.demo.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@Entity
@Table
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "user_generator")
    private int id;
    private String name;
    private String email;
    @Transient
    private int age;
    private LocalDate dob;
    private boolean orderProcessed = false;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void update() {
        orderProcessed = true;
    }
}
