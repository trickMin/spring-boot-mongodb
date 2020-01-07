package org.yt.springbootmongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.yt.springbootmongodb.dao.CommentRepository;
import org.yt.springbootmongodb.pojo.Comment;

import java.util.List;
import java.util.Queue;

/**
 * ClassName: CommentService <br/>
 * Description: Comment类的业务类<br/>
 * date: 2020/1/7 11:47 <br/>
 *
 * @author Min <br/>
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存一条Comment记录
     * @param comment
     */
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    /**
     * 更新Comment记录
     * @param comment
     */
    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }

    /**
     * 根据id删除Comment记录
     * @param id
     */
    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    /**
     * 根据id查询一条Comment记录
     * @param id
     * @return
     */
    public Comment findCommentById(String id){
        return commentRepository.findById(id).get();
    }

    public Page<Comment> listCommentsByParentid(String parentid,Integer pageNo,Integer pageSize){
        //构建分页请求（分页的必要条件）
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        //根据parentid和分页条件pageRequest执行分页查询
        return commentRepository.findByParentid(parentid,pageRequest);
    }

    /**
     * 查询所有Comment记录
     * @return
     */
    public List<Comment> findAllComment(){
        return commentRepository.findAll();
    }

    /**
     * 更新点赞数
     * @param id
     */
    public void updateCommentLikenum(String id){
        //构建查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        //构建更新内容
        Update update = new Update();
        update.inc("likenum");
        //执行更新
        mongoTemplate.updateFirst(query,update,Comment.class);
    }

}
