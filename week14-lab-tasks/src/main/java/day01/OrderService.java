package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public List<Order> findOrdersByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    // Határozd meg a rendelések darabszámát egy paraméterként kapott státusz alapján

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(status))
                .count();
    }

    // Add vissza azokat a rendeléseket, amik két dátum között vannak.

    public List<Order> getOrdersBetweenDates(LocalDate date1, LocalDate date2) {
        return orders.stream()
                .filter(o -> o.getOrderDate().isAfter(date1) && o.getOrderDate().isBefore(date2))
                .collect(Collectors.toList());
    }

    // Van-e olyan rendelés amiben kevesebb mint paraméternyi termék található.

    public boolean isOrderWithLessProductThan(int number) {
        return orders.stream()
                .anyMatch(o -> o.getProducts().size() < number);
    }

    // Keresd meg azt a rendelést, amiben a legtöbb termék található.

    public Order getOrderWithMaxNumberOfProducts() {
        return orders.stream()
//                .max(new Comparator<Order>() {
//                    @Override
//                    public int compare(Order o1, Order o2) {
//                        return o1.getProducts().size() - o2.getProducts().size();
//                    }
//                })
//                .max((o1, o2) -> o1.getProducts().size() - o2.getProducts().size ())
                .max(Comparator.comparingInt(o -> o.getProducts().size()))
                .orElseThrow(() -> new IllegalStateException("List is empty"));

            // .sorted(Collections.reverseOrder(Comparator.comparing(o->o.getProducts().size())))
            // .findFirst().orElseThrow(()->new IllegalStateException("Empty List"));
    }

    // (Nehezebb) Gyűjtsük ki azokat a rendeléseket, amiben van megadott kategóriájú termék.

    public List<Order> getOrdersWithProductInCategory(String category){
        return orders.stream()
                .filter(o->o.getProducts().stream().anyMatch(p->p.getCategory().equals(category)))
                .collect(Collectors.toList());
    }
}
