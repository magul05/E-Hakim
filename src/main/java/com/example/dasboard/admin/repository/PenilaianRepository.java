package com.example.dasboard.admin.repository;

import com.example.dasboard.admin.model.Penilaian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenilaianRepository extends JpaRepository<Penilaian, Long> {

    // Tambahan opsional: ambil semua penilaian berdasarkan hakim tertentu
    List<Penilaian> findByHakimId(Long hakimId);
}
