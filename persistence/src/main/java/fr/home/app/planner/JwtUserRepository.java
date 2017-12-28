package fr.home.app.planner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtUserRepository extends JpaRepository<JwtUser, Long>{
    public JwtUser findJwtUserByUserName(String username);
}
