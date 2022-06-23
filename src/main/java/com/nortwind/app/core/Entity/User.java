package com.nortwind.app.core.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "users"/*,uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}*/)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    @Email
    @NotBlank(message = "email boş bırakılamaz.")
    @NotNull(message = "email boş bırakılamaz.")
    private String email;

    @Column(name = "password")
    @NotBlank(message = "şifre boş bırakılamaz.")
    @NotNull(message = "şifre boş bırakılamaz.")
    private String password;
}
