package ge.vakhtang.pm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "PRODUCTS")
@Data
@ToString
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;
    @NotNull
    private LocalDateTime registrationTime;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Integer quantity;
    @PositiveOrZero
    private Double price;

    @JsonIgnore
    @ManyToOne
    private UserEntity user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProductAttributeEntity> attributes;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CurrencyEntity currency;
}
