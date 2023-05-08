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

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'majitel';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllOwners();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'zk.builder';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllTraineeBuilders();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'helper';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllHelpers();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'builder';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllBuilders();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'sp.majitel';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllCoOwners();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'eventer';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllEventers();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'hl.helper';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllMainHelpers();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'zk.helper';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllTraineeHelpers();

    @Query(value = "SELECT * FROM luckperms_players WHERE primary_group = 'admin';",nativeQuery = true)
    @Transactional
    List<LuckPermsPlayerEntity> findAllAdmins();

}
