package org.launchcode.spaday.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class User {
//fields
private int id;
    private static int nextId = 0;

    @NotBlank(message="UserName cannot be blank")
    @Size(min=5,max=15,message="Username should be between 5 and 15 characters")
    private String username;

    @Email(message = "Invalid Email. Try Again!")
    private String email;

    @NotBlank(message="Password cannot be blank")
    @Size(min=6,message="Password should be minimum of 6 characters")
    private String password;

//    @NotBlank(message="Verify Password cannot be blank")
//    @NotNull(message="Passwords do not match")
//    private String verifyPassword;

    //Constructors
    public User(){
        this.id = nextId;
        nextId++;
    }

    public User(String id,String username, String email, String password) {
        this();
//        this.id = nextId;
        this.username = username;
        this.email = email;
        this.password = password;
//        this.verifyPassword = verifyPassword;
//        nextId++;
    }

    //Getters and Setters
    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
//        this.checkPassword();
    }

//    public String getVerifyPassword() {
//        return verifyPassword;
//    }

//    public void setVerifyPassword(String verify) {
//        this.verifyPassword = verifyPassword;
////        this.checkPassword();
//    }

    //toString

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //hascode and equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    //Setup a new method to verify password
//    private void checkPassword(){
//        if((this.password != null) && (this.verifyPassword != null) && (this.password != this.verifyPassword)){
//            this.verifyPassword = null;
//        }
//
//    }
}
