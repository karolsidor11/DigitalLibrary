package pl.sidor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sidor.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public BookDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Book findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findAll() {


        Map<String, Object> params = new HashMap<>();

        String query = "SELECT * FROM books";


        List<Book> result = namedParameterJdbcTemplate.query(query, params, new BookMapper());

        return result;
    }

    public static final class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setPages(resultSet.getInt("pages"));
            book.setIsbn(resultSet.getString("isbn"));
            return book;
        }
    }
}
