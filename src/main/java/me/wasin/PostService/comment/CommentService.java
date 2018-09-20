package me.wasin.PostService.comment;

import me.wasin.PostService.post.Post;
import me.wasin.PostService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(Comment comment, int postId) {
        Post post = new Post();
        post.setId(postId);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

//    public Comment createComment(Comment comment, int postId, int userId) {
//        Post post = new Post();
//        post.setId(postId);
//
//        User user = new User();
//        user.setId(userId);
//
//        comment.setPost(post);
//        comment.setUser(user);
//        return commentRepository.save(comment);
//    }

}
