package gcsj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import gcsj.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findUserByName(String name);

    User findUserByNameAndPasswd(String name, String password);
}