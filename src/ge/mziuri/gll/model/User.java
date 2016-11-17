package ge.mziuri.gll.model;

public class User {

    private String name;
    private String surname;
    private Long identification;
    private String password;
    private String confirmpassword;

    public User() {
    }

    public User(String name, String surname, Long identification, String password, String confirmpassword) {
        this.name = name;
        this.surname = surname;
        this.identification = identification;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getIdentification() {
        return identification;
    }

    public void setIdentification(Long identification) {
        this.identification = identification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

}
