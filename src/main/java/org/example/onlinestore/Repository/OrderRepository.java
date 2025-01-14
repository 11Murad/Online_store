package org.example.onlinestore.Repository;
import org.example.onlinestore.Entity.Order;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>(List.of(
       new Order(45,1,"Book"),
       new Order(46,1,"Laptop"),
       new Order(47,2,"Vape Dragon Fruit"),
       new Order(48,3,"LG 4k TV 50 inc"),
       new Order(49,4,"")
    ));

    public List<Order> getAllOrders() {
        return orders;
    }

    public Order getOrderByOrderId(int id) {
        return orders.stream().filter(o->o.getOrderId()==id).
                findFirst().orElseThrow(()->new RuntimeException("Order not found"));
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void deleteOrderByOrderId(int id) {
        orders.removeIf(o->o.getOrderId()==id);
    }

}
