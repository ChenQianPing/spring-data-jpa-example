package com.pingkeke.rdf.service;

import com.pingkeke.rdf.domain.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * IUserService.
 */
public interface IUserService {

    List<User> findAll();

    void saveUser(User book);

    User findOne(long id);

    void delete(long id);

    List<User> findByName(String name);

    Page<User> findPage(int page,int size);
}
