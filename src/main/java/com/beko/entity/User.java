package com.beko.entity;

import com.beko.converter.BirthdayConvertor;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@TypeDef(name = "Bekooo", typeClass = JsonBinaryType.class)
@Table(name = "users", schema = "public")
public class User {
    @Id
    private String username;

    private String firstname;

    private String lastname;

    @Convert(converter = BirthdayConvertor.class)
    @Column(name = "birth_date")
    private Birthday birthDate;

    @Type(type = "Bekooo")
    private String info;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}

