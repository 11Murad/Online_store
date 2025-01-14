package org.example.onlinestore.Service;

import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.RequiredArgsConstructor;
import org.example.onlinestore.Entity.Order;
import org.example.onlinestore.Repository.OrderRepository;
import org.example.onlinestore.model.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getOrdersByUserId(Integer userId) {
        if (userId != null) {
            return orderRepository.getAllOrders().stream().filter(o->o.getUserId()==userId).toList();
        }
        return orderRepository.getAllOrders();
    }

    public Order getOrderByOrderId(Integer orderId) {
        return orderRepository.getOrderByOrderId(orderId);
    }

    public void addOrder(Order order) {
        if (order != null) {
            orderRepository.addOrder(order);
        }
    }

    public void deleteOrderByOrderId(Integer orderId) {
        if (orderId != null) {
            orderRepository.deleteOrderByOrderId(orderId);
        }
    }

    public void update(int id, OrderRequest orderRequest) {
        Order order = orderRepository.getOrderByOrderId(id);

        order.setUserId(orderRequest.getUserId());
        order.setItemName(orderRequest.getItemName());
    }
}
