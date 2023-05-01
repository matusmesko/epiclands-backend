package sk.meski.epiclands.luckpermsplayer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


}
