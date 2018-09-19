package me.wasin.PostService.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> createPost(@Valid @RequestBody Comment comment) {
        Comment comment_object = commentService.createComment(comment);
        return new ResponseEntity<Comment>(comment_object, HttpStatus.OK);
    }

}
