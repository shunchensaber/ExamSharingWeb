package me.hades.entiy;

import javax.persistence.*;
import java.util.List;

@Entity
public class SysPermission  {
    @Id
    @GeneratedValue
    private Integer id;//主键.
    private String name;//名称.
    @Column(columnDefinition="enum('menu','button')")
    private String resourceType ="menu";//资源类型，[menu|button]
    //private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    //private Long parentId; //父编号
   // private String parentIds; //父编号列表
    private Boolean available = Boolean.FALSE;
    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;

    public SysPermission()
    {

    }
    public SysPermission(String name, String resourceType, String permission, Boolean available) {
        this.name = name;
        this.resourceType = resourceType;
        this.permission = permission;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getPermission() {
        return permission;
    }

    public Boolean getAvailable() {
        return available;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}