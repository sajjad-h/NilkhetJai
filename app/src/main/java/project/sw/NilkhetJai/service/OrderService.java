package project.sw.NilkhetJai.service;

import java.util.List;
import java.util.Optional;

import project.sw.NilkhetJai.models.Order;

public interface OrderService {
    /**
     * To save Order object in orders table
     * 
     * @param Order
     */
    void save(Order order);

    /**
     * To find by id form orders table
     * 
     * @param id
     * @return
     */

    Optional<Order> findById(Long id);

    /**
     * To find all object from orders table
     * 
     * @return
     */
    List<Order> findAll();

}
