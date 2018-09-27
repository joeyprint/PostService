package me.wasin.PostService.comment;

import me.wasin.PostService.post.Post;
import me.wasin.PostService.post.PostService;
import me.wasin.PostService.user.User;
import me.wasin.PostService.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int id) {
        return commentRepository.findById(id);
    }

    public List<Comment> getCommentByPostId (int postId) {
        return commentRepository.findByPostId(postId);
    }

    public Comment createComment(Comment comment, int postId, int userId) {
        Post post = postService.getPostById(postId);
        User user = userService.getUserById(userId);
        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

}
