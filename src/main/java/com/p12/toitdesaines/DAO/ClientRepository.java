package com.p12.toitdesaines.DAO;

import com.p12.toitdesaines.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin
public interface ClientRepository extends JpaRepository <Client,Long> {

    @Query(value = "SELECT * FROM client",nativeQuery = true)
     List<Client> findThem();

}
