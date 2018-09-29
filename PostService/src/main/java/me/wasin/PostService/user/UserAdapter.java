package me.wasin.PostService.user;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserAdapter {

    public User getUserDetail(long userId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user/" + userId;
        User user = restTemplate.getForObject(url, User.class);
        return user;
    }

    public User[] getAllUser () {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/users";
        User[] user_object = restTemplate.getForObject(url, User[].class);
        return user_object;
    }

    public User createUser (User user) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user";
        User newUser = restTemplate.postForObject(url, user, User.class);
        return newUser;
    }
}
