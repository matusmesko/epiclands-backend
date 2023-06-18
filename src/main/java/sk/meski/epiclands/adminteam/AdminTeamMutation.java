package sk.meski.epiclands.adminteam;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import sk.meski.epiclands.luckpermsplayer.LuckPermsPlayerEntity;
import sk.meski.epiclands.luckpermsplayer.LuckPermsPlayerRepository;
import sk.meski.epiclands.status.StatusEntity;
import sk.meski.epiclands.status.StatusType;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Validated
@Component
@Slf4j
@RequiredArgsConstructor

public class AdminTeamMutation implements GraphQLMutationResolver{

    private final LuckPermsPlayerRepository luckPermsPlayerRepository;
    private final AdminTeamRepository adminTeamRepository;

//    public StatusEntity updatePlayers() {
//        List<LuckPermsPlayerEntity> luckpermsPlayers = luckPermsPlayerRepository.findAll();
//        List<AdminTeamEntity> updatedPlayers = new ArrayList<>();
//
//        for (LuckPermsPlayerEntity lp: luckpermsPlayers) {
//            if (lp.getPrimary_group() == "majitel") {
//                System.out.println(lp.getUsername() + lp.getPrimary_group());
//                String mojangUuid = getUuid(lp.getUsername());
//                AdminTeamEntity entity = new AdminTeamEntity();
//                entity.setMojangUuid(lp.getUuid());
//                entity.setName(lp.getUsername());
//                entity.setPosition(lp.getPrimary_group());
//                updatedPlayers.add(entity);
//                adminTeamRepository.save(entity);
//            }
//            if (lp.getPrimary_group() == "sp.majitel")   {
//                String mojangUuid = getUuid(lp.getUsername());
//                AdminTeamEntity entity = new AdminTeamEntity(mojangUuid, lp.getUsername(), lp.getPrimary_group());
//                updatedPlayers.add(entity);
//                adminTeamRepository.save(entity);
//            }
//        }
//
//
//        return new StatusEntity(StatusType.SUCCESS, "Hráči boli updatnutý!");
//    }

    public StatusEntity updatePlayers() {
        updateGroup(luckPermsPlayerRepository.findAllOwners(), adminTeamRepository.getAllOwners());
        return new StatusEntity(StatusType.SUCCESS, "Hráči boli updatnutý!");
    }

    private void updateGroup(List<LuckPermsPlayerEntity> luckPermsPlayer, List<AdminTeamEntity> currentAT) {
        List<LuckPermsPlayerEntity> luckpermsPlayers = luckPermsPlayer;
        List<AdminTeamEntity> currentOwners = currentAT;
        List<AdminTeamEntity> iterable = new ArrayList<>();
        for (LuckPermsPlayerEntity l: luckpermsPlayers) {
            AdminTeamEntity entity = new AdminTeamEntity();
            entity.setUsername(l.getUsername());
            entity.setUuid(getUuid(l.getUsername()));
            entity.setPrimary_group(l.getPrimary_group());
            iterable.add(entity);

            for (AdminTeamEntity a : currentOwners) {
                if (!l.getUsername().contains(a.getUsername())) {
                    adminTeamRepository.delete(a);
                }
            }
        }
        adminTeamRepository.saveAll(iterable);
    }

    public String getUuid(String name) {
        String url = "https://api.mojang.com/users/profiles/minecraft/"+name;
        try {
            @SuppressWarnings("deprecation")
            String UUIDJson = IOUtils.toString(new URL(url));
            if(UUIDJson.isEmpty()) return "invalid name";
            JSONObject UUIDObject = (JSONObject) JSONValue.parseWithException(UUIDJson);
            return UUIDObject.get("id").toString();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            throw new RuntimeException(e);
        }

        return "3fb7eb4d29834087b8e879a8a1752768";
    }
}
