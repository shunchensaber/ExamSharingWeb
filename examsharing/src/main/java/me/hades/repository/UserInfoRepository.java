package me.hades.repository;

import me.hades.entiy.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUsername(String username);
    public UserInfo findByName(String name);

    public UserInfo findByUsernameAndPassword(String username,String password);
}
