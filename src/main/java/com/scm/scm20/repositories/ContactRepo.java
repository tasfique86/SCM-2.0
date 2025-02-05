package com.scm.scm20.repositories;

import com.scm.scm20.entities.Contact;
import com.scm.scm20.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepo extends JpaRepository<Contact, String> {

    // find the contact by user

    //custom finder method
    List<Contact> findByUser (User user);

    // custom query method
    @Query("SELECT c FROM Contact c WHERE c.user.id = :userId")
    List<Contact> findByUserId (@Param("userId") String userId);
}
