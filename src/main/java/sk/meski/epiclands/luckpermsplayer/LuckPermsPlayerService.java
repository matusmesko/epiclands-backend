package sk.meski.epiclands.luckpermsplayer;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LuckPermsPlayerService {

    private final LuckPermsPlayerRepository luckPermsPlayerRepository;

    public List<LuckPermsPlayerEntity> getAllLuckpermsPlayers() {
        return luckPermsPlayerRepository.findAll();
    }


    public List<LuckPermsPlayerEntity> getPlayersByRank(String rank) {
        return luckPermsPlayerRepository.findAllByRank(rank);
    }


    public List<LuckPermsPlayerEntity> getOwners() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllOwners();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getTraineeBuilders() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllTraineeBuilders();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getHelpers() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllHelpers();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getBuilders() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllBuilders();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getCoOwners() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllCoOwners();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getEventers() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllEventers();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getMainHelpers() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllMainHelpers();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getTraineeHelpers() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllTraineeHelpers();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getAdmins() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllAdmins();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
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

        return "ce7ea4cb078947c9b536144f836a30c2";
    }


}
