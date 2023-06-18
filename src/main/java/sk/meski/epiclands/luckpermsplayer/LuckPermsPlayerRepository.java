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

    LuckPermsPlayerEntity findByUsername(String username);


    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'majitel' OR primary_group = 'zk.builder' OR primary_group = 'helper' OR primary_group = 'builder' OR primary_group = 'sp.majitel' OR primary_group = 'eventer' OR primary_group = 'hl.helper' OR  primary_group = 'zk.helper' OR  primary_group = 'admin' OR  primary_group = 'developer' OR  primary_group = 'hl.builder' OR  primary_group = 'hl.developer' OR  primary_group = 'hl.technik' OR  primary_group = 'technik' OR primary_group = 'tester' OR  primary_group = 'vedení';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllAT();



}
