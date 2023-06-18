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
import java.util.stream.Collectors;


@Validated
@Component
@Slf4j
@RequiredArgsConstructor

public class AdminTeamMutation implements GraphQLMutationResolver{

    private final LuckPermsPlayerRepository luckPermsPlayerRepository;
    private final AdminTeamRepository adminTeamRepository;


    public StatusEntity updatePlayers() {
        updateGroup();
        return new StatusEntity(StatusType.SUCCESS, "Hráči boli updatnutý!");
    }

    private void updateGroup() {
        List<LuckPermsPlayerEntity> luckpermsPlayers = luckPermsPlayerRepository.findAllAT();
        List<AdminTeamEntity> currentAt = adminTeamRepository.findAll();

        List<AdminTeamEntity> newAt = new ArrayList<>();

        // New people to AT
        for (LuckPermsPlayerEntity l : luckpermsPlayers) {
            boolean existsInLuckPerms = false;
            for(AdminTeamEntity at : currentAt) {
                if (l.getUsername().equals(at.getUsername())){
                    existsInLuckPerms = true;
                    break;
                }
            }
            if(!existsInLuckPerms) {
                AdminTeamEntity newAtMember = new AdminTeamEntity();
                newAtMember.setUsername(l.getUsername());
                newAtMember.setPrimary_group(l.getPrimary_group());
                newAtMember.setUuid(getUuid(l.getUsername()));
                newAt.add(newAtMember);
            }
        }

        adminTeamRepository.saveAll(newAt);

        // Remove players after derank
        for (AdminTeamEntity l : currentAt) {
            boolean existsInLuckPerms = false;
            for(LuckPermsPlayerEntity at : luckpermsPlayers) {
                if (l.getUsername().equals(at.getUsername())){
                    existsInLuckPerms = true;
                    break;
                }
            }
            if(!existsInLuckPerms) {
                adminTeamRepository.delete(l);
            }
        }


        // When change rank
        for (AdminTeamEntity l : currentAt) {
            boolean existsInLuckPerms = false;
            for(LuckPermsPlayerEntity at : luckpermsPlayers) {
                if (l.getUsername().equals(at.getUsername()) && !l.getPrimary_group().equals(at.getPrimary_group())){
                        AdminTeamEntity entity = adminTeamRepository.findByUsername(l.getUsername());
                        entity.setPrimary_group(at.getPrimary_group());
                        adminTeamRepository.save(entity);
                    existsInLuckPerms = true;
                    break;
                }


            }

        }

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
