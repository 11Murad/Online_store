package org.example.onlinestore.Controller;

import lombok.RequiredArgsConstructor;
import org.example.onlinestore.Entity.Order;
import org.example.onlinestore.Repository.OrderRepository;
import org.example.onlinestore.Service.OrderService;
import org.example.onlinestore.model.OrderRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> findAllOrders(@RequestParam(required = false) Integer userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/{id}")
    public Order getOrderByOrderId(@PathVariable Integer id) {
        return orderService.getOrderByOrderId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderByOrderId(@PathVariable Integer id) {
        orderService.deleteOrderByOrderId(id);
    }

    @PutMapping("/{id}")
    public void updateOrderByOrderId(@PathVariable Integer id, @RequestBody OrderRequest order) {
        orderService.update(id, order);
    }

}
