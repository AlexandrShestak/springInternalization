package daoTest;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import com.shestakam.dao.UserDao;
import com.shestakam.entities.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

/**
 * Created by alexandr on 10.7.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-configuration.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    @DatabaseTearDown("/testData/userData.xml")
    @ExpectedDatabase(value = "/testData/userAddExpectedData.xml", assertionMode= DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testAddUser() throws Exception {
        User user = new User();
        user.setLogin("dark");
        user.setFirstName("Alex");
        user.setLastName("Mac");
        user.setPassword("12345678");
        user.setLanguage("EN");
       // User actual = userDao.get("dark");
        userDao.add(user);
        //Assert.assertEquals(user,actual);
    }

    @Test
    @DatabaseTearDown("/testData/userData.xml")
    public void testGetUser() throws Exception {
        User expected = new User();
        expected.setLogin("eric");
        expected.setFirstName("Qwert");
        expected.setLastName("Yuiop");
        expected.setPassword("13567");
        expected.setLanguage("RU");
        User actual = userDao.get("eric");
        Assert.assertEquals(expected,actual);
    }

    @Test
    @DatabaseTearDown("/testData/userData.xml")
    @ExpectedDatabase(value = "/testData/userDeleteExpectedData.xml", assertionMode= DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testDeleteUser() throws Exception {
        userDao.delete("eric");
    }

    @Test
    @DatabaseTearDown("/testData/userData.xml")
    @ExpectedDatabase(value = "/testData/userEditExpectedData.xml", assertionMode= DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testEditUser() throws Exception {
        User user = new User();
        user.setLogin("eric");
        user.setFirstName("Qwert");
        user.setLastName("Yuiop");
        user.setPassword("1356789");
        user.setLanguage("RU");
        userDao.edit(user);
    }


}
