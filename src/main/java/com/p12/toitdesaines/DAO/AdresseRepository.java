package com.p12.toitdesaines.DAO;

import com.p12.toitdesaines.entity.Adresse;
import com.p12.toitdesaines.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface AdresseRepository extends JpaRepository<Adresse,Long> {
}
