package com.pristavka.patient_card.repo;

import com.pristavka.patient_card.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByEmail(String email);
}
