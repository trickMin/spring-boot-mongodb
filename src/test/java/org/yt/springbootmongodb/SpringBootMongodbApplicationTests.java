package org.yt.springbootmongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;
import org.yt.springbootmongodb.pojo.Comment;
import org.yt.springbootmongodb.service.CommentService;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMongodbApplicationTests {

    @Autowired
    private CommentService commentService;

    /**
     * 测试添加记录
     */
    @Test
    public void testSaveComment() {
        Comment comment = new Comment();
        comment.setId("3");
        comment.setArticleid("1");
        comment.setContent("真不错");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setLikenum(20);
        comment.setNickname("黑暗之魂");
        comment.setParentid("0");
        comment.setPublishtime(new Date());
        comment.setReplynum(2);
        comment.setState("0");
        comment.setUserid("1");
        commentService.saveComment(comment);
    }

    /**
     * 测试根据id查询指定评论记录
     */
    @Test
    public void testFindById(){
        String id = "2";
        Comment comment = commentService.findCommentById(id);
        System.out.println(comment);
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Comment> commentList = commentService.findAllComment();
        for (Comment comment:commentList){
            System.out.println("-------------------------------------------");
            System.out.println(comment);
            System.out.println("/-------------------------------------------");
        }
    }

    /**
     * 测试根据parentid进行分页查询
     */
    @Test
    public void testListCommentsByParentid(){
        String parentid = "0";
        //由于mongodb分页是从第0页开始，因此pageNo要减1
        Integer pageNo = 1;
        Integer pageSize = 2;
        Page<Comment> commentPage = commentService.listCommentsByParentid(parentid, pageNo - 1, pageSize);
        System.out.println(commentPage.getContent());
    }

    /**
     * 测试更新点赞数（+1）
     */
    @Test
    public void testUpdateCommentLikenum(){
        String id = "1";
        commentService.updateCommentLikenum(id);
    }

    /**
     * 测试根据id删除评论记录
     */
    @Test
    public void testDeleteById(){
        String id = "1";
        commentService.deleteCommentById(id);
        System.out.println("删除完毕...");
    }

}
