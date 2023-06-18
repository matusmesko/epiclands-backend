package sk.meski.epiclands.adminteam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "web_adminteam")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdminTeamEntity {

    @Id
    private String uuid;
    private String username;
    private String primary_group;
}
