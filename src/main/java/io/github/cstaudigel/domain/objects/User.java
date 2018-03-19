package io.github.cstaudigel.domain.objects;

import java.sql.Date;

/**
 * The file User.java was created by Chris on 1:08 PM at 3/17/2018
 */

public class User {
    private int id;
    private Date dob;
    private Date joinDate;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordHash;

    public User(int id, Date dob, Date joinDate, String username, String email, String firstName, String lastName, String password, String passwordHash) {
        this.id = id;
        this.dob = dob;
        this.joinDate = joinDate;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordHash = passwordHash;
    }

    public User(Date dob, Date joinDate, String username, String email, String firstName, String lastName, String password, String hash) {
        this.dob = dob;
        this.joinDate = joinDate;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.passwordHash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
