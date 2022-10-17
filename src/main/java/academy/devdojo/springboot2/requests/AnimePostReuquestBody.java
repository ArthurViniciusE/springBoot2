package academy.devdojo.springboot2.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AnimePostReuquestBody {
    @NotEmpty(message = "The anime name cannot be empty/null")
    private String name;
}
