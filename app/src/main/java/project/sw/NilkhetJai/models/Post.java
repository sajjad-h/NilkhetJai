package project.sw.NilkhetJai.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @Lob
    @Column
    @NotEmpty
    private String content;

    @Column
    private LocalDateTime createdOn;

    @Column
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * 
     * @return
     */

    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     */

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     */

    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return
     */

    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     */

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     */

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    /**
     * 
     * @param createdOn
     */

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * 
     * @return
     */

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    /**
     * 
     * @param updatedOn
     */

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}