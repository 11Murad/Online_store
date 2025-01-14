package org.example.onlinestore.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    private int orderId;
    private int userId;
    private String itemName;
}
