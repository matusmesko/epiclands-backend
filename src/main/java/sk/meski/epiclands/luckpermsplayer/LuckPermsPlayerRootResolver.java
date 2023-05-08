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

    public List<LuckPermsPlayerEntity> getOwners() {
        return luckPermsPlayerService.getOwners();
    }

    public List<LuckPermsPlayerEntity> getTraineeBuilders() {
        return luckPermsPlayerService.getTraineeBuilders();
    }

    public List<LuckPermsPlayerEntity> getHelpers() {
        return luckPermsPlayerService.getHelpers();
    }

    public List<LuckPermsPlayerEntity> getBuilders() {
        return luckPermsPlayerService.getBuilders();
    }

    public List<LuckPermsPlayerEntity> getCoOwners() {
        return luckPermsPlayerService.getCoOwners();
    }

    public List<LuckPermsPlayerEntity> getEventers() {
        return luckPermsPlayerService.getEventers();
    }

    public List<LuckPermsPlayerEntity> getMainHelpers() {
        return luckPermsPlayerService.getMainHelpers();
    }

    public List<LuckPermsPlayerEntity> getTraineeHelpers() {
        return luckPermsPlayerService.getTraineeHelpers();
    }

    public List<LuckPermsPlayerEntity> getAdmins() {
        return luckPermsPlayerService.getAdmins();
    }

}
