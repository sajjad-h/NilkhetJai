package project.sw.NilkhetJai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.sw.NilkhetJai.models.Order;
import project.sw.NilkhetJai.repository.OrderRepository;

@Service
public class OrderServiceIMP implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    /**
     * To find by id form book table
     */

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * To find all object from book table
     */

    @Override
    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
