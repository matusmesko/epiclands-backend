package sk.meski.epiclands.luckpermsplayer;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
@AllArgsConstructor
public class LuckPermsPlayerRootResolver implements GraphQLQueryResolver {
    private final LuckPermsPlayerService luckPermsPlayerService;

    public List<LuckPermsPlayerEntity> getAllLuckpermsPlayers() {
       return luckPermsPlayerService.getAllLuckpermsPlayers();
    }

    public List<LuckPermsPlayerEntity> getPlayersByRank(String rank) {
        return luckPermsPlayerService.getPlayersByRank(rank);
    }

}
