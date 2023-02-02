package ge.vakhtang.pm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "CURRENCIES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyEntity {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank
    private String code;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    private ProductEntity product;
}
