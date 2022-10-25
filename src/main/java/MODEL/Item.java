package MODEL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor@Getter@Setter@AllArgsConstructor
@Document("MIniStore")
public class Item {

    @Id
    private String id;

    private boolean isActive;
    private String name;
    private String desc;
    private Double cost;
    private String category;
    private String imageUrl;
}
