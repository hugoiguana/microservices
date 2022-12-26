package hugo.mota.microservices.mssales.entity;


import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class AbstractPersistentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime dtCriation;

    @Column(nullable = false)
    private LocalDateTime dtModification;

    public void prePersist() {
        dtCriation = LocalDateTime.now();
        dtModification = LocalDateTime.now();
    }


}
