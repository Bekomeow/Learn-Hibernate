package com.beko.entity;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_chat")
public class UserChat extends AuditableEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    public void setUser (User user) {
        this.user = user;
        user.getUserChats().add(this);
    }

    public void setChat (Chat chat) {
        this.chat = chat;
        chat.getUserChats().add(this);
    }
}
