package com.randygunshop.gunshop.repository;

import com.randygunshop.gunshop.model.Gun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GunRepository extends JpaRepository<Gun, Long> {
}
