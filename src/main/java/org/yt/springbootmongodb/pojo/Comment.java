package org.yt.springbootmongodb.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName: Comment <br/>
 * Description: 评论实体类<br/>
 * date: 2020/1/7 11:25 <br/>
 *
 * @author Min <br/>
 */
//@CompoundIndex(def = "{'userid':1,'nickname':-1}")  //组合索引，userid升序，nickname降序
@Document("comment") //可忽略，忽略则类名小写映射mongodb中的集合
public class Comment implements Serializable {
    //主键标识，用@Id会将该属性自动匹配到_id，如果属性名为id，则注解可以不写
    @Id
    private String id;
    //@Field 用于标识mongodb中字段的名字，如果属性名和字段名一致，则注解可以不写
    @Field ("content")
    private String content;
    private Date publishtime;
    //为userid加上单字段索引
    @Indexed
    private String userid;
    private String nickname;
    private LocalDateTime createdatetime;
    private Integer likenum;
    private Integer replynum;
    private String state;
    private String parentid;
    private String articleid;

    /**
     * ------------------------------------toString-------------------------------------------
     */

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", publishtime=" + publishtime +
                ", userid='" + userid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createdatetime=" + createdatetime +
                ", likenum=" + likenum +
                ", replynum=" + replynum +
                ", state='" + state + '\'' +
                ", parentid='" + parentid + '\'' +
                ", articleid='" + articleid + '\'' +
                '}';
    }

    /**
     * ------------------------------------getter&setter-------------------------------------------
     */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(LocalDateTime createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getReplynum() {
        return replynum;
    }

    public void setReplynum(Integer replynum) {
        this.replynum = replynum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }
}
