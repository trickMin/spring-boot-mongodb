package org.yt.springbootmongodb.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.yt.springbootmongodb.pojo.Comment;

/**
 * ClassName: CommentRepository <br/>
 * Description: 创建mongodb中comment集合的持久层<br/>
 * date: 2020/1/7 11:45 <br/>
 *
 * @author Min <br/>
 */
public interface CommentRepository extends MongoRepository<Comment,String> {

    /**
     * 根据parentid执行分页查询
     * 方法名一定要按规范来写，idea会有提示！！
     * @param parentid
     * @param pageable
     * @return
     */
    Page<Comment> findByParentid(String parentid, Pageable pageable);

}
