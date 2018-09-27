package me.wasin.PostService.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> posts = postService.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/post/{post_id:[\\d]}", method = RequestMethod.GET)
    public ResponseEntity<Post> getAPostWithComment(@PathVariable(name = "post_id") int id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{user_id:[\\d]}/post", method = RequestMethod.POST)
    public ResponseEntity<Post> createPost(@PathVariable(name = "user_id") int userId, @Valid @RequestBody Post post) {
        Post post_object = postService.createPost(post, userId);
        return new ResponseEntity<Post>(post_object, HttpStatus.OK);
    }

}
