package com.pingkeke.rdf.service;

import com.pingkeke.rdf.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserServiceTest.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Test
    public void testFindOne() throws Exception {
        User u1 = userService.findOne(100);
        System.out.println("第一次查询：" + u1.getName());


        /**
         * 到这里，我们可以看到，在调用第二次findOne函数时，
         * 没有再执行select语句，也就直接减少了一次数据库的读取操作。
         */
        User u2 = userService.findOne(100);
        System.out.println("第二次查询：" + u2.getName());

    }


}
