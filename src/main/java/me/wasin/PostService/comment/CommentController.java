package me.wasin.PostService.comment;

import me.wasin.PostService.post.PostRepository;
import me.wasin.PostService.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getAllComment() {
        List<Comment> comments = commentService.getAllComment();
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    @RequestMapping(value = "/comment/{comment_id:[\\d]}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getComment (@PathVariable (name = "comment_id") int id) {
        Comment comment = commentService.getCommentById(id);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user_id:[\\d]}/post/{post_id:[\\d]}/comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> createCommentInPost (@PathVariable(name = "user_id") int userId,
                                                        @PathVariable(name = "post_id") int postId,
                                                        @Valid @RequestBody Comment comment) {
        Comment comment_object = commentService.createComment(comment, postId, userId);
        return new ResponseEntity<Comment>(comment_object, HttpStatus.OK);
    }

}
