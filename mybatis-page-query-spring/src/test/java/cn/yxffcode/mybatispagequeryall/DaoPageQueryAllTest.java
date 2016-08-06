package cn.yxffcode.mybatispagequeryall;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gaohang on 16/7/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class DaoPageQueryAllTest {

    @Resource
    private UserDao userDao;

    @Test
    public void testBatch() {

        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name:" + i);
            userDao.insert(user);
        }

        List<User> results = userDao.selectAll();
        for (User result : results) {
            System.out.println(result);
        }
    }
}
