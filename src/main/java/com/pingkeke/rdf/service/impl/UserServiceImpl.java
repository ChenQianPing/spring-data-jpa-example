package com.pingkeke.rdf.service.impl;

import com.pingkeke.rdf.domain.User;
import com.pingkeke.rdf.repository.UserJpaRepository;
import com.pingkeke.rdf.repository.UserRepository;
import com.pingkeke.rdf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl.
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll()
    {
        return userJpaRepository.findAll();
    }

    public List<User> findByName(String name)
    {
        List<User> userList1 = userRepository.findByName1(name);
        List<User> userList2 = userRepository.findByName2(name);
        List<User> userList3 = userRepository.findByNameAndAddress(name, "111");
        System.out.println("userList1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }

    public void saveUser(User user)
    {
        userJpaRepository.save(user);
    }

    /**
     * @Cacheable 用于一个表示缓存该方法的返回值。后续对该方法的调用，可以不执行该方法，
     * 直接从缓存中返回结果。
     * @param id
     * @return
     */
    @Cacheable("users")
    public User findOne(long id)
    {
        System.out.println("Cached Pages");
        return userJpaRepository.findOne(id);
    }

    public void delete(long id)
    {
        userJpaRepository.delete(id);
    }


    /**
     * Pageable 是Spring Data库中定义的一个接口，
     * 该接口是所有分页相关信息的一个抽象，
     * 通过该接口，我们可以得到和分页相关所有信息（例如pageNumber、pageSize等），
     * 这样，Jpa就能够通过pageable参数来得到一个带分页信息的Sql语句。
     *
     * Page类也是Spring Data提供的一个接口，
     * 该接口表示一部分数据的集合以及其相关的下一部分数据、数据总数等相关信息，
     * 通过该接口，我们可以得到数据的总体信息（数据总数、总页数...）
     * 以及当前数据的信息（当前数据的集合、当前页数等）

     * @return
     */
    public Page<User> findPage(int page,int size) {

        // int page=0,size=10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return userJpaRepository.findAll(pageable);

    }



}
