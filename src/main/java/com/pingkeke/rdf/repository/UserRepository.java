package com.pingkeke.rdf.repository;

import com.pingkeke.rdf.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * UserRepository.
 *
 * 这里的UserRepository接口主要定义了一些查询方法；

 比如这里的findByNameAndAddress和findByName方法，
 我们是不需要额外定义其它查询语句就可以直接执行的，
 Spring Data Jpa会根据实体类的属性名字以及方法名自动实现该方法；

 PS:由于我们在实体类中声明了@NamedQuery注解，
 实际上findByName方法会使用@NamedQuery注解标注的查询语句去查询；

 另外这里的findByName1方法使用了HQL语句查询；

 findByName2方法使用了原始的sql语句查询；
 */
public interface UserRepository extends Repository<User, Long> {

    List<User> findByNameAndAddress(String name, String address);

    @Query(value = "from User u where u.name=:name")
    List<User> findByName1(@Param("name") String name);

    @Query(value = "select * from #{#entityName} u where u.name=?1", nativeQuery = true)
    List<User> findByName2(String name);

    List<User> findByName(String name);
}
