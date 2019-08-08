package me.hades.Service;

import me.hades.entiy.SysPermission;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysPermissionServiceTest {
//    @Autowired
//    SysPermissionService sysPermissionService;

    @Test
    public void savesys()
    {
        SysPermissionService sysPermissionService= new SysPermissionService();
        SysPermission sysPermission = new SysPermission();
        sysPermission.setAvailable(true);
        sysPermission.setName("增加");
        sysPermission.setPermission("add");
        SysPermission sysPermission1 = sysPermissionService.save(sysPermission);
        Assert.assertNotNull(sysPermission1);

    }


}