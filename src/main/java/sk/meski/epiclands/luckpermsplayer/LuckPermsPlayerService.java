package sk.meski.epiclands.luckpermsplayer;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;
import sk.meski.epiclands.adminteam.AdminTeamEntity;
import sk.meski.epiclands.adminteam.AdminTeamRepository;
import sk.meski.epiclands.status.StatusEntity;
import sk.meski.epiclands.status.StatusType;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LuckPermsPlayerService {

    private final LuckPermsPlayerRepository luckPermsPlayerRepository;

    private final AdminTeamRepository adminTeamRepository;

    public List<LuckPermsPlayerEntity> getAllLuckpermsPlayers() {
        return luckPermsPlayerRepository.findAll();
    }


    public List<LuckPermsPlayerEntity> getPlayersByRank(String rank) {
        return luckPermsPlayerRepository.findAllByRank(rank);
    }


    public List<LuckPermsPlayerEntity> getAdminTeam() {
        return luckPermsPlayerRepository.findAllAT();
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
