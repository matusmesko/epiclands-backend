package sk.meski.epiclands.adminteam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.meski.epiclands.luckpermsplayer.LuckPermsPlayerEntity;


import javax.transaction.Transactional;
import java.util.List;

public interface AdminTeamRepository extends JpaRepository<AdminTeamEntity, Long> {

    AdminTeamEntity findByUsername(String username);
}
