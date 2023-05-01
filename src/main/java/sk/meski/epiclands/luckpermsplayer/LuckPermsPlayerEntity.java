package sk.meski.epiclands.luckpermsplayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "luckperms_players")
@Data

public class LuckPermsPlayerEntity {

    @Id
    private String uuid;

    private String username;

    private String primary_group;

}
