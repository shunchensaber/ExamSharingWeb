package me.hades.entiy;

import org.thymeleaf.context.ILazyContextVariable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by hades on 2018/12/24.
 */
@Entity
@Table(name = "edunews")
public class EduNews{

    @Id
    @GeneratedValue
    private Integer id;

    private String title;

    private String img;

    private String brief;

    private String content;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy年MM月dd日");

        return s.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
