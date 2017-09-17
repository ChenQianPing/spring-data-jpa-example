package com.pingkeke.rdf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

/**
 * User.
 *
 * 注意下这里的@NamedQuery注解，
 * 大致意思就是让我们在Repository接口中定义的findByName方法不使用默认的查询实现，
 * 取而代之的是使用这条自定义的查询语句去查询，如果这里没有标注的话，会使用默认实现的。
 */
@Entity
@NamedQuery(name = "User.findByName", query = "select name,address from User u where u.name=?1")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    long id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

}
