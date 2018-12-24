package me.hades.repository;

import me.hades.entiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by hades on 2018/12/24.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    /**
     * 自定义Query
     */
    User findUserByUsername(String username);

}
