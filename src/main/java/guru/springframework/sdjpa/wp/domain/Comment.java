package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "wp_comments", indexes = {
        @Index(name = "comment_post_ID", columnList = "comment_post_ID"),
        @Index(name = "comment_approved_date_gmt", columnList = "comment_approved,comment_date_gmt"),
        @Index(name = "comment_date_gmt", columnList = "comment_date_gmt"),
        @Index(name = "comment_parent", columnList = "comment_parent"),
        @Index(name = "comment_author_email", columnList = "comment_author_email")
})
public class Comment {
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    public String getCommentAuthorURL() {
        return commentAuthorURL;
    }

    public void setCommentAuthorURL(String commentAuthorURL) {
        this.commentAuthorURL = commentAuthorURL;
    }

    public String getCommentAuthorIP() {
        return commentAuthorIP;
    }

    public void setCommentAuthorIP(String commentAuthorIP) {
        this.commentAuthorIP = commentAuthorIP;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public Set<CommentMeta> getCommentMetaSet() {
        return commentMetaSet;
    }

    public void setCommentMetaSet(Set<CommentMeta> commentMetaSet) {
        this.commentMetaSet = commentMetaSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
        this.commentDate = commentDate;
    }

    public Timestamp getCommentDateGMT() {
        return commentDateGMT;
    }

    public void setCommentDateGMT(Timestamp commentDateGMT) {
        this.commentDateGMT = commentDateGMT;
    }


    public Integer getCommentKarma() {
        return commentKarma;
    }

    public void setCommentKarma(Integer commentKarma) {
        this.commentKarma = commentKarma;
    }

    public String getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="comment_ID")
    private Long id;

    @NotNull
    @Column(name="comment_post_ID")
    private Long postId;

     @ManyToOne
     @JoinColumn(name="user_id")
     private User user;

     @NotNull
     @Column(name="comment_author",columnDefinition = "tinytext")
     private String commentAuthor;

    @NotNull
    @Size(max=100)
    @Column(name="comment_author_email")
    private String commentAuthorEmail;

    @NotNull
    @Size(max=200)
    @URL
    @Column(name="comment_author_url")
    private String commentAuthorURL;

    @NotNull
    @Size(max=100)
    @Column(name="comment_author_IP")
    private String commentAuthorIP;

    @NotNull
    @Column(name = "comment_date")
    private Timestamp commentDate;

    @NotNull
    @Column(name = "comment_date_gmt")
    private Timestamp commentDateGMT;

    @NotNull
    @Column(name="comment_content", columnDefinition = "text")
    private String content;

    @NotNull
    @Column(name = "comment_karma")
    private Integer commentKarma;

    @NotNull
    @Size(max = 20)
    @Column(name="comment_approved")
    private String commentApproved;

    @NotNull
    @Size(max = 255)
    @Column(name="comment_agent")
    private String commentAgent;

    @NotNull
    @Size(max = 20)
    @Column(name="comment_type")
    private String commentType;

    @ManyToOne
    @JoinColumn(name="comment_parent")
    private Comment parent;


    @OneToMany
    @JoinColumn(name = "comment_id")
    private Set<CommentMeta> commentMetaSet;
}
