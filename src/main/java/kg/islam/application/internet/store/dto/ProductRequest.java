package kg.islam.application.internet.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private String prize;
    private String type;
    private Integer count;
}
