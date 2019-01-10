package pl.sidor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
import java.util.Optional;

@Repository
public class BookDaoImpl implements BookDao {

    private static final String FIND_BY_TITLE_QUERY = "SELECT * FROM books WHERE TITLE LIKE ?";
    private static final String FIND_ALL = "SELECT * FROM books";
    private static final String ADD_NEW_BOOK = "INSERT INTO books VALUES (?,?,?,?,?)";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id=?";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public BookDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.dataSource = dataSource;
    }

    @Override
    public List<Book> findByTitle(String title) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Map<String, Object> map = new HashMap<>();
        title = new StringBuffer(title).append("%").toString();
        map.put("text", title);

        try {
            List<Book> query1 = jdbcTemplate.query(FIND_BY_TITLE_QUERY, new Object[]{title}, new BookMapper());
            return query1;
        } catch (EmptyResultDataAccessException e) {
            Optional.empty();
            return null;
        }
    }


    @Override
    public List<Book> findAll() {

        Map<String, Object> params = new HashMap<>();

        return namedParameterJdbcTemplate.query(FIND_ALL, params, new BookMapper());
    }

    @Override
    public void add(Book book) {

        int id = findAll().size() + 1;
        String title = book.getTitle();
        String author = book.getAuthor();
        int pages = book.getPages();
        String isbn = book.getIsbn();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(ADD_NEW_BOOK, new Object[]{id, title, author, pages, isbn});

    }

    @Override
    public void delete(Integer id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(DELETE_BOOK, new Object[]{id});
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
