package sk.meski.epiclands.adminteam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "web_adminteam")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminTeamEntity {

    @Id
    private String username;

    private String uuid;

    private String primary_group;
}
