package sk.meski.epiclands.luckpermsplayer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface LuckPermsPlayerRepository extends JpaRepository<LuckPermsPlayerEntity, Long> {

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = ?1",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllByRank(String rank);


}
