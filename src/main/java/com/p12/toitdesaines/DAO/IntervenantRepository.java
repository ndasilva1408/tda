package com.p12.toitdesaines.DAO;

import com.p12.toitdesaines.entity.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface IntervenantRepository extends JpaRepository<Intervenant,Long> {
}
