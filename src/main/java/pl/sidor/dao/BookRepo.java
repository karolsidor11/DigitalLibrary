package pl.sidor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.model.Book;

import java.util.List;

@Repository()
@Transactional
public interface BookRepo extends JpaRepository<Book, Integer> {

    Book save(Book book);

    Book findByTitle(String title);

    Book findById(int id);

    void deleteById(int id);

    @Override
    List<Book> findAll();
}
