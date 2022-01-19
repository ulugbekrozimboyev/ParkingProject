package uz.epam.parking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Spot {

    public static final String STATE_FREE = "FREE";
    public static final String STATE_BUSY = "BUSY";

    private Integer level;
    private Integer spotNumber;
    private Boolean isFree;

    public String freeMsg() {
        return this.isFree ? STATE_FREE : STATE_BUSY;
    }
}
