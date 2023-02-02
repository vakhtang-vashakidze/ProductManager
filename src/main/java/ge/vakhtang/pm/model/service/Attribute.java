package ge.vakhtang.pm.model.service;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Attribute {
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private String value;
}
