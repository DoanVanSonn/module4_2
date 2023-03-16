package com.example.ajaxandquerry.service;

import com.example.ajaxandquerry.model.SmartPhone;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IServiceSmartPhone {
    Iterable<SmartPhone> findAll();

    Optional<SmartPhone> findById(Long id);

    SmartPhone save(SmartPhone smartPhone);

    void remove(Long id);
}
