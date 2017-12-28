package fr.home.app.planner.views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserView {

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;

    private String street;
    private int postalZip;
    private String city;
    private String country;
    private String complement;
    private String addressName;

}
