package ua.edu.ucu.apps.demo.orders;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Order {
    @Getter
    private final List<Integer> itemIds = new ArrayList<>();
    @Getter
    private final List<Integer> userIds = new ArrayList<>();
    @Setter
    private Payment payment;
    @Getter
    @Setter
    private Delivery delivery;

    public void addItem(Integer id) {
        this.itemIds.add(id);
    }

    public void addUser(Integer id) {
        this.userIds.add(id);
    }

    public boolean removeItem(Integer id) {
        return this.itemIds.remove(id);
    }
}