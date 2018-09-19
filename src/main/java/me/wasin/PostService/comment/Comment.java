package me.wasin.PostService.comment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import me.wasin.PostService.post.Post;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "comments")
@EntityListeners(AuditingEntityListener.class)
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "post_id", nullable = false)
//    @JsonIgnore
//    private Post post;

    @NotBlank
    private String comment;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    public Comment() {
        super();
    }



//    public Comment(Post post, @NotBlank String comment) {
//        this.post = post;
//        this.comment = comment;
//    }

    public Comment(@NotBlank String comment) {
        this.comment = comment;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setPost(Post post) {
//        this.post = post;
//    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

//    public Post getPost() {
//        return post;
//    }

    public String getComment() {
        return comment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
