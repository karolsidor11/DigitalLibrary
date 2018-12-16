package pl.sidor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sidor.model.Login;
import pl.sidor.model.User;

import java.util.List;


@Repository("userRepository")
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {

    User save(User user);

    User findByName(String name);

    User findById(int id);

    void deleteById(int id);

    User findByLogin(Login login);

    @Override
    List<User> findAll();
}
