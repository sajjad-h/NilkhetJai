package project.sw.NilkhetJai.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requestedBook")
public class RequestedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String type;
    private String name;
    private String author;
    private String language;

    /**
     * Empty Constractor for book object
     */

    public RequestedBook() {
        super();
    }

    /**
     * To getType from book object
     * 
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * To setType for book object
     * 
     * @param type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * To set book name for book object
     * 
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * To get book name from book object
     * 
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * To get book author from book object
     * 
     * @return
     */

    public String getAuthor() {
        return author;
    }

    /**
     * To set Author for book
     * 
     * @param author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * To get Language from book
     * 
     * @return
     */

    public String getLanguage() {
        return language;
    }

    /**
     * To set Language for book object
     * 
     * @param language
     */

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * To get id form book object
     * 
     * @return
     */

    public Long getId() {
        return id;
    }

    /**
     * To set id for book object
     * 
     * @param id
     */

    public void setId(Long id) {
        this.id = id;
    }
}
