package com.randygunshop.gunshop.service;

import com.randygunshop.gunshop.model.Gun;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GunService
{
    List<Gun> findall();
    Gun findById(Long id);
    Gun save(Gun gun);
    void deleteById(Long id);
}
