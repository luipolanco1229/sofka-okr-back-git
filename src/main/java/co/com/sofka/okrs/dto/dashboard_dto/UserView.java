package co.com.sofka.okrs.dto.dashboard_dto;

import java.util.Objects;

public class UserView {

    private String name;
    private String email;

    public UserView(String name, String email){
        this.name = Objects.requireNonNull(name);
        this.email = Objects.requireNonNull(email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserView that = (UserView) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
