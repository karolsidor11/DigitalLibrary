package pl.sidor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sidor.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {

    Login findByLoginAndPassword(String login, String password);
}
