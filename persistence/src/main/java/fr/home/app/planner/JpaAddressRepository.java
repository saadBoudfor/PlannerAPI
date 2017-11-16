package fr.home.app.planner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAddressRepository extends JpaRepository<Address, Long> {
}
