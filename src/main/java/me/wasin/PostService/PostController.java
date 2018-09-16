package me.wasin.PostService;

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
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

//    @RequestMapping(value = "/post/{post_id:[\\d]}", method = RequestMethod.GET)
//    public ResponseEntity<List<Post>> getPost(@PathVariable(name = "id") int id) {
//        Post post = postService.getPostById();
//        return new ResponseEntity<Post>(post, HttpStatus.OK);
//    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        Post post_object = postService.createPost(post);
        return new ResponseEntity<Post>(post_object, HttpStatus.OK);
    }

}
