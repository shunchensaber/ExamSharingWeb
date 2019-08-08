package me.hades.entiy;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "fileinfo")
public class FileInfo {
    /**
     * 唯一标识
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 文件名
     */
    private String filename;
    /**
     * 文件路径
     */
    private String path;
    /**
     * 上传者用户
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "UserFile")
    @JoinColumn(name="uid")
    private UserInfo uif;
    /**
     * 文件状态
     */
    private String state;
    /**
     * 文件所属科目
     */
    private String discipline;

    /**
     * 文件上传
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadtime;

    public FileInfo()
    {

    }

    public FileInfo(String filename, String path, UserInfo uif, String state, String discipline, Date uploadtime) {
        this.filename = filename;
        this.path = path;
        this.uif = uif;
        this.state = state;
        this.discipline = discipline;
        this.uploadtime = uploadtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public UserInfo getUif() {
        return uif;
    }

    public void setUif(UserInfo uif) {
        this.uif = uif;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", path='" + path + '\'' +
                ", uif=" + uif +
                ", state='" + state + '\'' +
                ", discipline='" + discipline + '\'' +
                ", uploadtime=" + uploadtime +
                '}';
    }
}


