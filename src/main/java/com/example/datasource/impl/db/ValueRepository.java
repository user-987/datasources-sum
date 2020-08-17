package com.example.datasource.impl.db;

import com.example.datasource.impl.db.model.InputValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ValueRepository extends JpaRepository<InputValue, String> {
}
