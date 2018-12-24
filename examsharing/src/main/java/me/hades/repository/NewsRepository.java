package me.hades.repository;

import me.hades.entiy.EduNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hades on 2018/12/24.
 */
@Repository
public interface NewsRepository extends JpaRepository<EduNews, Integer> {


}
