package sk.meski.epiclands.adminteam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.meski.epiclands.luckpermsplayer.LuckPermsPlayerEntity;

import javax.transaction.Transactional;
import java.util.List;

public interface AdminTeamRepository extends JpaRepository<AdminTeamEntity, Long> {
    @Query(value = "SELECT * FROM web_adminteam WHERE position = ?1",nativeQuery = true)
    @Transactional
    List<AdminTeamEntity> getAllByRank(String rank);

    @Query(value = "SELECT * FROM web_adminteam WHERE primary_group = 'majitel';",nativeQuery = true)
    @Transactional
    List<AdminTeamEntity> getAllOwners();
}
