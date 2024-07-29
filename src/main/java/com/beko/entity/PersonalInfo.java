package com.beko.entity;

import com.beko.converter.BirthdayConvertor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class PersonalInfo {
    private String firstname;

    private String lastname;

//    @Convert(converter = BirthdayConvertor.class)
//    @Column(name = "birth_date")
    private Birthday birthDate;
}

