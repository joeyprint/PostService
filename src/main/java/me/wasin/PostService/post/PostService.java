package me.wasin.PostService.post;

import me.wasin.PostService.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id);
    }

    public Post createPost(Post post, int userId) {
        User user = new User();
        user.setId(userId);
        post.setUser(user);
        return postRepository.save(post);
    }

}
