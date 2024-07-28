package com.beko.entity;

import com.beko.converter.BirthdayConvertor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    private String username;

    private String firstname;

    private String lastname;

    @Convert(converter = BirthdayConvertor.class)
    @Column(name = "birth_date")
    private Birthday birthDate;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
