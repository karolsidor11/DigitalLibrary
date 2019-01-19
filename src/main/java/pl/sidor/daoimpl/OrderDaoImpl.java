package pl.sidor.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.sidor.dao.OrderDAO;
import pl.sidor.model.Book;
import pl.sidor.model.Order;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDAO {

    private static final String ADD_NEW_ORDER = "INSERT INTO orders VALUES(?,?,?,?)";
    private static final String SHOW_ORDER = "SELECT * FROM orders";

    private DataSource dataSource;

    @Autowired
    public OrderDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addOrder(Order order) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(ADD_NEW_ORDER, new Object[]{1, "Java", order.getUser(), order.getDateOfReturn()});

    }

    @Override
    public List<Order> showOrder() {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(SHOW_ORDER, new OrderMapper());
    }

    public static final class OrderMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order order = new Order();
            order.setId(resultSet.getInt("id"));
            order.setBookList((List<Book>) resultSet.getObject("bookList"));
            order.setUser(resultSet.getString("user"));
            order.setDateOfReturn(resultSet.getString("dateOfReturn"));
            return order;
        }
    }
}
