package sk.meski.epiclands.adminteam;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;
import sk.meski.epiclands.luckpermsplayer.LuckPermsPlayerEntity;
import sk.meski.epiclands.luckpermsplayer.LuckPermsPlayerRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AdminTeamService {

    private final LuckPermsPlayerRepository luckPermsPlayerRepository;
    private final AdminTeamRepository adminTeamRepository;

//    public List<AdminTeamEntity> updatePlayers() {
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
//        return  updatedPlayers;
//    }

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
