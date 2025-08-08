package com.example.dasboard.admin.repository;

import com.example.dasboard.admin.model.Kriteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KriteriaRepository extends JpaRepository<Kriteria, Long> {
    // Tambahkan custom query jika diperlukan
}
