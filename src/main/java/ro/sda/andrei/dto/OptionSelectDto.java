package ro.sda.andrei.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class OptionSelectDto implements Comparable<OptionSelectDto> {

    private Long id;

    private String text;


    @Override
    public int compareTo(OptionSelectDto o) {
        return this.text.compareTo(o.getText());
    }
}
