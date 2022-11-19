package ua.edu.ucu.apps.demo.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ucu.apps.demo.users.AppUserService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderManager {
    private final List<Order> orders = new ArrayList<>();
    private final AppUserService userService;

    @Autowired
    public OrderManager(AppUserService userService) {
        this.userService = userService;
        Order order = new Order();
        order.setDelivery(new DHLDeliveryStrategy());
        order.setPayment(new PayPalPaymentStrategy());
        order.addItem(1);
        order.addUser(1);
        orders.add(order);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orders;
    }

    @GetMapping("process")
    public String processOrder() {
        for (Order order : orders) {
            notify(order);
        }
        return "Orders processed";

    }

    public void notify(Order order) {
        for (Integer userId : order.getUserIds()) {
            userService.updateUser(userId);
        }
    }

}
