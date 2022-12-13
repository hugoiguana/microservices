package hugo.mota.microservices.mssales.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id"))
        , @AttributeOverride(name = "dtCriation", column = @Column(name = "dt_criation"))
        , @AttributeOverride(name = "dtModification", column = @Column(name = "dt_modification"))
})
public class ProductEntity extends AbstractPersistentEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @PrePersist
    public void prePersist() {
        super.prePersist();
    }

}
