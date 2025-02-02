package Entity;

public class User {
    private String name;
    private String email;
    private String phone;
    private String gender;
    private String location;
    private String password;

    public User(String name, String email, String phone, String gender, String location, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.location = location;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getLocation() {
        return location;
    }

    public String getPassword() {
        return password;
    }
}
