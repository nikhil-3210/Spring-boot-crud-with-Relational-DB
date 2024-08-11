package com.nikhiljadav.spring_boot_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentId")
    private Long id;

    @NotBlank(message = "First Name cannot be empty")
    @Column(name = "firstName", nullable = false)
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Range(min = 0, max = 100, message = "Percentage must be between 0 and 100")
    @NotNull(message = "percentage cannot be empty")
    @Column(name = "percentage", nullable = false)
    private Long percentage;

    @Email(message = "Please provide valid email ID")
    @NotBlank(message = "email id cannot be empty")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Pattern(regexp = "^\\d{3}-\\d{3}-\\d{4}$", message = "Phone Number should be in the format XXX-XXX-XXXX")
    @NotBlank(message = "Phone Number cannot be empty")
    @Column(name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPercentage() {
        return percentage;
    }

    public void setPercentage(Long percentage) {
        this.percentage = percentage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", percentage=" + percentage +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
