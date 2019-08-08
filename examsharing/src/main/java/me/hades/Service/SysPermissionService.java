package me.hades.Service;

import me.hades.entiy.SysPermission;
import me.hades.repository.SysPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionService {
    @Autowired
    SysPermissionRepository sysPermissionRepository;

    /**
     * 查询所有的权限
     * @return List<Syspermission>
     */
    public List<SysPermission> getpermisssions()
    {
        List<SysPermission> permissions = sysPermissionRepository.findAll();
        return permissions;
    }
    /**
     * 数据库插入权限信息
     */
    public SysPermission save(SysPermission sysPermission)
    {
     SysPermission sysPermission1 = sysPermissionRepository.save(sysPermission);
     return sysPermission1;
    }



}
