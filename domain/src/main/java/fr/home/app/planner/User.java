package fr.home.app.planner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
@Data
class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Id
    private String username;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USERS_ADDRESS_LISTS")
    private Collection<Address> addressList;
    @ManyToMany
    @JoinTable(name = "USERS_ROLES_LISTS")
    private Collection<Role> roles;
}
