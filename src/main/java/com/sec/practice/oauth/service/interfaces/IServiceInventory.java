package com.sec.practice.oauth.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;

public interface IServiceInventory<T> {

    @PostAuthorize("hasAuthority('READ_ALL')")
    Page<T> findAll(Pageable page);

    @PostAuthorize("hasAuthority('READ_ONE')")
    T findById(Long id);

    @PostAuthorize("hasAuthority('DISABLE_ONE')")
    T remove(Long id);

    @PostAuthorize("hasAuthority('UPDATE_ONE')")
    T update(T object);

    @PostAuthorize("hasAuthority('CREATE_ONE')")
    T save(T object);
}
