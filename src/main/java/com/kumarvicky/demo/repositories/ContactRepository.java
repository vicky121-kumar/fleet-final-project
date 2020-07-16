package com.kumarvicky.demo.repositories;

import com.kumarvicky.demo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contact")
public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
