package fr.tcapi.server.api.ranks;

import fr.tcapi.others.data.TryCubeData;
import fr.tcapi.server.integration.TeamTags;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Rank implements Listener {

    @EventHandler
    public void rankAttribute(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());

        if(cubeData.file.exists()) {
            TeamTags.setNameTag(p, RankList.getByRankName(cubeData.getRank()).getPower(), RankList.getByRankName(cubeData.getRank()).getPrefix(), RankList.getByRankName(cubeData.getRank()).haveBadge());
        }
    }
}
