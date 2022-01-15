package project.sw.NilkhetJai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import project.sw.NilkhetJai.models.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {
    Optional<Cart> findById(Long id);

    List<Cart> findAll();
}
