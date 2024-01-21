package pl.mirocha.marcin.it.book.store.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RegisterUserDTO {
    private String name;
    private String surname;
    private String login;
    private String password;
    private String password2;

}
