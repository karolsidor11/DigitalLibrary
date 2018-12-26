package pl.sidor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sidor.model.User;

import javax.sql.DataSource;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private DataSource dataSource;
    private User user;


    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource source) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.dataSource = source;
    }

    @Override
    public User findByName(String name) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

        String sql = "SELECT * FROM users WHERE name=:name";

        User result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());

        //new BeanPropertyRowMapper(Customer.class));

        return result;

    }

    @Override
    public List<User> findAll() {

        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "SELECT * FROM users";

        List<User> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

        return result;

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
        insert.update("INSERT INTO USERS (id,name, email,login, password) VALUES(?,?,?,?,?)", new Object[]{id, user.getName(), user.getEmail(), user.getLogin(), user.getPassword()});


    }

    @Override
    public User findByLoginAndPassword(String login, String password) {

        Map<String, String> map = new HashMap<>();

        map.put("login", login);
        map.put("password", password);


        String query = "SELECT * FROM users WHERE login=:login AND password=:password";


        User user = namedParameterJdbcTemplate.queryForObject(query, map, new UserMapper());

        return user;
    }

    @Override
    public void delete(int id) {
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
//
        String query = "DELETE FROM users WHERE id=?";
        Object[] params = {id};
        int[] types = {Types.BIGINT};

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(query, params, types);

    }

    @Override
    public void update(User user) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String query = "UPDATE  users SET name=?, email=?, login=?,password=? WHERE id=?";
        Object[] name = {user.getName(), user.getEmail(), user.getLogin(), user.getPassword(), 1};

        jdbcTemplate.update(query, name);


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