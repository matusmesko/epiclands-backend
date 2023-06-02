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
import java.util.stream.Collectors;

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

    public List<LuckPermsPlayerEntity> getDevelopers() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllDevelopers();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getMainBuilders() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllMainBuilders();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getMainDevelopers() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllMainDevelopers();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getMainTechnics() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllMainTechnics();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getTechnics() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllTechnics();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getTesters() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllTesters();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getManagement() {
        List<LuckPermsPlayerEntity> players = luckPermsPlayerRepository.findAllManagement();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();
        for (LuckPermsPlayerEntity player : players) {
            LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
            String newUuid = getUuid(entity.getUsername());
            entity.setUuid(newUuid);
            newPlayers.add(entity);
        }
        return newPlayers;
    }

    public List<LuckPermsPlayerEntity> getAdminTeam() {
        List<LuckPermsPlayerEntity> adminTeam = luckPermsPlayerRepository.findAll();
        List<LuckPermsPlayerEntity> newAdminTeam = new ArrayList<>();
        List<LuckPermsPlayerEntity> newPlayers = new ArrayList<>();

        for (int i = 0; i < getOwners().size(); i++) {
            for (LuckPermsPlayerEntity player : getOwners()) {
                LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
                String newUuid = getUuid(entity.getUsername());
                entity.setUuid(newUuid);
                newPlayers.add(entity);
            }
            newAdminTeam.add(newPlayers.stream().filter(p -> p.getPrimary_group().equalsIgnoreCase("majitel"))
                    .collect(Collectors.toList()).get(i));
        }

        for (int i = 0; i < getCoOwners().size(); i++) {
            for (LuckPermsPlayerEntity player : getCoOwners()) {
                LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
                String newUuid = getUuid(entity.getUsername());
                entity.setUuid(newUuid);
                newPlayers.add(entity);
            }
            newAdminTeam.add(newPlayers.stream().filter(p -> p.getPrimary_group().equalsIgnoreCase("sp.majitel"))
                    .collect(Collectors.toList()).get(i));
        }

        for (int i = 0; i < getHelpers().size(); i++) {
            for (LuckPermsPlayerEntity player : getHelpers()) {
                LuckPermsPlayerEntity entity = luckPermsPlayerRepository.findByUsername(player.getUsername());
                String newUuid = getUuid(entity.getUsername());
                entity.setUuid(newUuid);
                newPlayers.add(entity);
            }
            newAdminTeam.add(newPlayers.stream().filter(p -> p.getPrimary_group().equalsIgnoreCase("helper"))
                    .collect(Collectors.toList()).get(i));
        }


        return newAdminTeam;
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
