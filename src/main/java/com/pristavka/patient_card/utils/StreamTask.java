package com.pristavka.patient_card.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTask {

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public StreamTask() {
        customers = List.of(
                new Customer("1", List.of(new Order(2), new Order(5), new Order(2))),
                new Customer("2", List.of()),
                new Customer("3", List.of(new Order(9), new Order(5), new Order(2)))
        );
    }

    class Order {
        private int amount;

        public Order(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }

    class Customer {
        private String name;
        private List<Order> orders;

        public Customer(String name, List<Order> orders) {
            this.name = name;
            this.orders = orders;//0679169082
        }

        public String getName() {
            return name;
        }

        public List<Order> getOrders() {
            return orders;
        }
    }

    /**
     * Write a function which accepts a list of customers and finds a customer with largest order
     * <p>
     * Result should be a customer
     */
    public static Optional<Customer> getCustomerWithLargestOrder(List<Customer> customers) {
        return customers
                .stream()
                .max(Comparator.comparing(c -> c.getOrders()
                        .stream()
                        .mapToInt(Order::getAmount)
                        .max()
                        .orElse(0)));

        /*return customers
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(c -> c.getOrders().stream().mapToInt(Order::getAmount).max().orElse(0))));*/
    }

    /**
     * Write a function which accepts a list of customers and counts sum of amounts of all orders per customer
     * <p>
     * Result should look like a map with
     * "customer1" -> 9
     * "customer2" -> 0
     * "customer3" -> 16
     */
    public static Map<String, Integer> calculateSumPerCustomer(List<Customer> customers) {
        return customers
                .stream()
                .collect(Collectors.toMap(Customer::getName, c -> c.getOrders()
                        .stream()
                        .mapToInt(Order::getAmount)
                        .sum()));
    }


    @Test
    void check() {
        List<Customer> customers = new StreamTask().getCustomers();
        Assertions.assertEquals("3", getCustomerWithLargestOrder(customers).map(Customer::getName).orElse(null));
        Map<String, Integer> sumPerCustomer = calculateSumPerCustomer(customers);
        Assertions.assertEquals(9, sumPerCustomer.get("1"));
        Assertions.assertEquals(0, sumPerCustomer.get("2"));
        Assertions.assertEquals(16, sumPerCustomer.get("3"));
    }
}

