package com.restaurant_app.repository;

import com.restaurant_app.model.FelPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelPrincipalRepository extends JpaRepository<FelPrincipal, Long> {

}
