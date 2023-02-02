package ge.vakhtang.pm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "PRODUCT_ATTRIBUTES")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAttributeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;
    @NotBlank
    private String type;
    @NotBlank
    private String value;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductEntity product;
}
