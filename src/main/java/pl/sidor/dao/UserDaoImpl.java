package pl.sidor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import pl.sidor.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private static final String FIND_BY_NAME = "SELECT * FROM users WHERE name=:name";
    private static final String FIND_ALL_USERS = "SELECT * FROM users";
    private static final String ADD_NEW_USER = "INSERT INTO USERS (id,name, email,login, password) VALUES(?,?,?,?,?)";
    private static final String DELETE_USER = "DELETE FROM users WHERE id=?";
    private static final String UPDATE_USER = "UPDATE  users SET name=?, email=?, login=?,password=? WHERE id=?";
    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=:login AND password=:password";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource source) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.dataSource = source;
    }

    @Override
    public User findByName(String name) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
//        List<User> query = namedParameterJdbcTemplate.query(FIND_BY_NAME, params, new UserMapper());

        return namedParameterJdbcTemplate.queryForObject(FIND_BY_NAME, params, new UserMapper());

    }

    @Override
    public List<User> findAll() {

        Map<String, Object> params = new HashMap<String, Object>();

        return namedParameterJdbcTemplate.query(FIND_ALL_USERS, params, new UserMapper());

    }

    @Override
    public void add(User user) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("name", user.getName());
        params.put("email", user.getEmail());
        params.put("login", user.getLogin());
        params.put("password", user.getPassword());

        int id = findAll().size() + 1;

        JdbcTemplate insert = new JdbcTemplate(dataSource);
//        insert.update(ADD_NEW_USER, new Object[]{id, user.getName(), user.getEmail(), user.getLogin(), user.getPassword()});
        insert.update(ADD_NEW_USER, id, user.getName(), user.getEmail(), user.getLogin(), user.getPassword());


    }

    @Override
    public User findByLoginAndPassword(String login, String password) {

        Map<String, String> map = new HashMap<>();

        map.put("login", login);
        map.put("password", password);

        User user = namedParameterJdbcTemplate.queryForObject(FIND_BY_LOGIN_AND_PASSWORD, map, new UserMapper());

        return user;
    }

    @Override
    public void delete(int id) {

        Object[] params = {id};
        int[] types = {Types.BIGINT};

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(DELETE_USER, params, types);
    }

    @Override
    public void update(User user) {

//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String name1 = authentication.getName();
//        Integer id = findByName(name1).getId();
//
//        Object[] name = {user.getName(), user.getEmail(), user.getLogin(), user.getPassword(), id};
//
//        jdbcTemplate.update(UPDATE_USER, name);

    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {

            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            return user;

        }
    }
}