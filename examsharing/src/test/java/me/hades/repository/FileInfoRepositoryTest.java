package me.hades.repository;


import me.hades.Constant.StateEnum;
import me.hades.entiy.FileInfo;
import me.hades.entiy.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileInfoRepositoryTest {
    @Autowired
    FileInfoRepository fileInfoRepository;
    @Autowired
    UserInfoRepository userInfoRepository;





    @Test
    public void saveUser()
    {
        UserInfo userInfo  = new UserInfo();
        userInfo.setName("陈顺");
        userInfo.setPassword("123456789");
        userInfo.setUsername("202170811");
        UserInfo info = userInfoRepository.save(userInfo);
        Assert.assertNotNull(info);

    }

    @Test
    public void testfile()
    {
        UserInfo userInfo = userInfoRepository.findByName("陈顺");
        FileInfo fileInfo = new FileInfo();
        fileInfo.setDiscipline("软件工程");
        fileInfo.setFilename("算法导论");
        fileInfo.setPath("C:/算法导论.txt");
        fileInfo.setState(StateEnum.wait.getState());
        fileInfo.setUploadtime(new Date());
        fileInfo.setUif(userInfo);
        FileInfo fileInfo1 = fileInfoRepository.save(fileInfo);
        Assert.assertNotNull(fileInfo1);

    }
    /**
     * 删除操作
     */
    @Test
    public void deletefiel()
    {
       //fileInfoRepository.deleteFileInfoByFilename("算法导论");
        fileInfoRepository.deleteById(6);
    }
    /**
     * 根据用户名和密码寻找
     */









}