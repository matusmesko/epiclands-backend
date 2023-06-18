package sk.meski.epiclands.luckpermsplayer;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import sk.meski.epiclands.status.StatusEntity;

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
        return null;
    }

    public List<LuckPermsPlayerEntity> getTraineeBuilders() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getHelpers() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getBuilders() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getCoOwners() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getEventers() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getMainHelpers() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getTraineeHelpers() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getAdmins() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getDevelopers() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getMainBuilders() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getMainDevelopers() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getMainTechnics() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getTechnics() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getTesters() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getManagement() {
        return null;
    }

    public List<LuckPermsPlayerEntity> getAdminTeam() {
        return luckPermsPlayerService.getAdminTeam();
    }


}
