package sk.meski.epiclands.status;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StatusEntity {
    private StatusType status;
    private String message;

}
