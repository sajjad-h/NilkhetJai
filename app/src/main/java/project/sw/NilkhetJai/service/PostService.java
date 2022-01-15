package project.sw.NilkhetJai.service;

import java.util.List;
import java.util.Optional;

import project.sw.NilkhetJai.models.Post;

public interface PostService {
    /**
     * To save book object in post table
     * 
     * @param book
     */
    void save(Post post);

    /**
     * To find by id form post table
     * 
     * @param id
     * @return
     */

    Optional<Post> findById(Long id);

    /**
     * To find all object from book table
     * 
     * @return
     */
    List<Post> findAll();

}
