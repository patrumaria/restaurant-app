package com.restaurant_app.repository;

import com.restaurant_app.model.FelPrincipal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MeniuRepository extends JpaRepository<FelPrincipal, Long> {
    List<FelPrincipal> findByPretGreaterThan(double pret);

    // nu trebuie să pui nimic aici, JpaRepository are findAll()
}
