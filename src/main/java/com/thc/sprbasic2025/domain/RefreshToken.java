package com.thc.sprbasic2025.domain;

import com.thc.sprbasic2025.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@EntityListeners(EntityListeners.class)
public class RefreshToken extends AuditingFields{
    Long userId;
    String dueDate;

    @Column(unique=true)
    String content;

    protected RefreshToken() {}
    private RefreshToken(Boolean deleted, Long userId, String dueDate, String content){
        this.deleted = deleted;
        this.userId = userId;
        this.dueDate = dueDate;
        this.content = content;
    }
    public static RefreshToken of(Long userId, String dueDate, String content){
        return new RefreshToken(false, userId, dueDate, content);
    }

    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}