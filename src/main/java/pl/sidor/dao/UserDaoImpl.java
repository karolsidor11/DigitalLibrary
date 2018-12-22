package pl.sidor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sidor.model.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

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

        int id = findAll().size() + 1;

        JdbcTemplate insert = new JdbcTemplate(dataSource);
        insert.update("INSERT INTO USERS (id,name, email) VALUES(?,?,?)", new Object[]{id, user.getName(), user.getEmail()});


    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }

}