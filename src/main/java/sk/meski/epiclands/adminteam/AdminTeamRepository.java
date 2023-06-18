package sk.meski.epiclands.adminteam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;

public interface AdminTeamRepository extends JpaRepository<AdminTeamEntity, Long> {


}
