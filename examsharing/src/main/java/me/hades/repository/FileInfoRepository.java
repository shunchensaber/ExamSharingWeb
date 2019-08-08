package me.hades.repository;

import me.hades.entiy.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface   FileInfoRepository extends JpaRepository<FileInfo,Integer> {

public void deleteFileInfosByFilename(List<String> filenames);
public void  deleteFileInfoByFilename(String filename);

}





