package project.sw.NilkhetJai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import project.sw.NilkhetJai.models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Optional<Order> findById(Long id);

    List<Order> findAll();
}
