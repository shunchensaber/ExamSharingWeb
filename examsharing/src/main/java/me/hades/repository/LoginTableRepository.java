package me.hades.repository;

import me.hades.entiy.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by hades on 2018/12/26.
 */
@Repository
public interface LoginTableRepository extends JpaRepository<LoginTable, Integer> {

    LoginTable findLoginTableByCookie(String cookie);

    LoginTable findLoginTableByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update login_table l set l.cookie = :cookie where l.username = :username")
    public int updateCookieByUsername(@Param("cookie") String cookie, @Param("username") String username);
}
