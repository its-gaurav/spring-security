package demo.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {

    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "{ "+this.id +" "+this.name+" }";
    }
}
