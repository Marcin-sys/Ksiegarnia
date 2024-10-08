package pl.mirocha.marcin.it.book.store.model.dto.rest;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserListDTO {
    private List<UserDTO> userDTOS = new ArrayList<>();
}
