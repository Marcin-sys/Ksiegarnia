package pl.mirocha.marcin.it.book.store.dao.memory;

import org.springframework.stereotype.Repository;
import pl.mirocha.marcin.it.book.store.dao.IOrderDAO;
import pl.mirocha.marcin.it.book.store.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderRepository implements IOrderDAO {
    private final IdSequence idSequence;

    private final List<Order> orders = new ArrayList<>();

    public OrderRepository(IdSequence orderIdSequence) {
        this.idSequence = orderIdSequence;
    }

    @Override
    public Optional<Order> getById(int id) {
        return this.orders.stream()
                .filter(o -> o.getId() == id)
                .map(Order::clone)
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return this.orders.stream()
                .map(Order::clone)
                .toList();
    }

    @Override
    public void save(Order order) {
        order.setId(this.idSequence.getId());
        this.orders.add(order);
    }

    @Override
    public void update(final Order order) {
        this.orders.stream()
                .filter(o -> o.getId() == order.getId())
                .forEach(o -> {
                    o.setUser(order.getUser());
                    o.setStatus(order.getStatus());
                    o.setTotal(order.getTotal());
                    o.getPositions().addAll(order.getPositions());
                });
    }

    @Override
    public void delete(final int id) {
        this.orders.stream()
                .filter(o -> o.getId() == id)
                .forEach(this.orders::remove);
    }

    @Override
    public List<Order> getByUserId(int userId) {
        return this.orders.stream()
                .filter(o -> o.getUser().getId() == userId)
                .toList();
    }
}
