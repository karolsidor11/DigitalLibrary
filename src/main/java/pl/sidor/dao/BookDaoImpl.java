package pl.sidor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sidor.model.Book;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public BookDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.dataSource = dataSource;
    }

    @Override
    public Book findByTitle(String title) {

        Map<String, Object> map = new HashMap<>();
        map.put("title", title);

        String query = "SELECT * FROM books WHERE title=:title";
        namedParameterJdbcTemplate.query(query, map, new BookMapper());
        Book book = namedParameterJdbcTemplate.queryForObject(query, map, new BookMapper());

        return book;
    }

    @Override
    public List<Book> findAll() {


        Map<String, Object> params = new HashMap<>();

        String query = "SELECT * FROM books";

        List<Book> result = namedParameterJdbcTemplate.query(query, params, new BookMapper());

        return result;
    }

    @Override
    public void add(Book book) {

        int id = findAll().size() + 1;
        String title = book.getTitle();
        String author = book.getAuthor();
        int pages = book.getPages();
        String isbn = book.getIsbn();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO books VALUES (?,?,?,?,?)", new Object[]{id,title,author,pages,isbn});


    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id) {

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
