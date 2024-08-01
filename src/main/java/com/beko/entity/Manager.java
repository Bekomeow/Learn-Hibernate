package com.beko.entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("manager")
public class Manager extends User {
    private String projectName;

    @Builder
    public Manager(Long id, PersonalInfo personalInfo, String username, String info, Role role,
                   Company company, Profile profile, List<UserChat> userChats, String projectName) {
        super(id, personalInfo, username, info, role, company, profile, userChats);
        this.projectName = projectName;
    }
}
