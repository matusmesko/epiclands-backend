package sk.meski.epiclands.adminteam;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class AdminTeamRootResolver implements GraphQLQueryResolver {
    private final AdminTeamService adminTeamService;

//    public List<AdminTeamEntity> updatePlayers() {
//       return adminTeamService.updatePlayers();
//    }
}
