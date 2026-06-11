package week4.example.prodfeatures.entities;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity {
    
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime date;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @CreatedBy // 👈 Uncomment this
    private String createdBy;

    @LastModifiedBy // 👈 Use @LastModifiedBy
    private String updatedBy;

    // ❌ Delete onCreate() and onUpdate() methods completely from here
}

