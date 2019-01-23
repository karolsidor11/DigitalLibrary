package pl.sidor.service;

import org.junit.Before;
import org.junit.Test;
import pl.sidor.dao.UserDaoImit;
import pl.sidor.model.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserServiceTest {


    private UserService userService;
    private User user;

    @Before
    public void before() {
        userService = new UserDaoImit();
    }

    @Test
    public void shouldFindAllUsers() {

        List<User> all = userService.findAll();
        assertEquals(0, all.size());
    }

    @Test
    public void shouldAddNewUser() {
        User user = new User(1, "Karol", "karolsidor11@wp.pl", "Karol", "qwerty");
        userService.add(user);

        assertNotNull(userService.findAll());
        assertEquals(1, userService.findAll().size());
    }

    @Test
    public void shouldFindByName() {
        user = new User(2, "Jan", "jan123@wp.pl", "Janek", "123456");

        userService.add(user);

        assertEquals(user, userService.findByName("Jan"));
    }

    @Test
    public void shouldDeleteUserById() {
        user = new User(2, "Karol", "karolsidor11@wp.pl", "karol", "123456");

        userService.add(user);
        userService.delete(2);

        assertEquals(0, userService.findAll().size());
    }

    @Test
    public void shouldUpdateUser() {
        user = new User(99, "Jan", "kowalski@wp.pl", "Janek", "jan123");

        userService.add(user);
        user.setName("Kamil");

        userService.update(user);

        assertEquals("Kamil", userService.findAll().stream().filter(user1 -> user1.getName().equals("Kamil")).findFirst().get().getName());

    }

}
