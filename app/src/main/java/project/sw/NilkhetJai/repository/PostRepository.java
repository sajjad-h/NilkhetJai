package project.sw.NilkhetJai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.sw.NilkhetJai.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
