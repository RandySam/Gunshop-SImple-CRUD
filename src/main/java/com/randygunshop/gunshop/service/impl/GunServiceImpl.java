package com.randygunshop.gunshop.service.impl;

import com.randygunshop.gunshop.model.Gun;
import com.randygunshop.gunshop.repository.GunRepository;
import com.randygunshop.gunshop.service.GunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GunServiceImpl implements GunService
{
    @Autowired
    private GunRepository gunRepository;

    @Override
    public List<Gun> findall() {
        return gunRepository.findAll();
    }

    @Override
    public Gun findById(Long id) {
        return gunRepository.findById(id).orElse(null);
    }

    @Override
    public Gun save(Gun gun) {
        return gunRepository.save(gun);
    }

    @Override
    public void deleteById(Long id) {
        gunRepository.deleteById(id);
    }
}
