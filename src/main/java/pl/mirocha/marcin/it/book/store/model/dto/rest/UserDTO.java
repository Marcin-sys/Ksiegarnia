package pl.mirocha.marcin.it.book.store.model.dto.rest;

import lombok.*;
import pl.mirocha.marcin.it.book.store.dao.IBookDAO;
import pl.mirocha.marcin.it.book.store.dao.IUserDAO;
import pl.mirocha.marcin.it.book.store.model.Position;
import pl.mirocha.marcin.it.book.store.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {


        private int id;
        private String login;
        private String password;
        private String name;
        private String surname;
        private pl.mirocha.marcin.it.book.store.model.User.Role role;
        private final Set<Position> cart = new HashSet<>();
        private Set<String> orders = new HashSet<>();



        public UserDTO(User user) {
                this.id = user.getId();
                this.login = user.getLogin();
                this.surname = user.getSurname();
                this.password = user.getPassword();
                this.role = user.getRole();
                this.orders.addAll(user.getOrders().stream()
                        .map(order -> "http://localhost:8080/api/v1/order/" + order.getId())
                        .toList());

        }
}
