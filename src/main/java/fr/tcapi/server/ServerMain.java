package fr.tcapi.server;

import fr.tcapi.server.api.ranks.Rank;
import fr.tcapi.server.api.ranks.RankList;
import fr.tcapi.server.command.*;
import fr.tcapi.others.data.TryCubeData;
import fr.tcapi.server.integration.TeamTags;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerMain extends JavaPlugin implements Listener {

    private long loaderTime;

    @Override
    public void onLoad() {
        loaderTime = System.currentTimeMillis();
    }

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new Rank(), this);

        long endTime = System.currentTimeMillis();
        long loadTime = endTime - loaderTime;

        getCommand("f").setExecutor(new FriendCommand());
        getCommand("report").setExecutor(new ReportManager());
        getCommand("try+").setExecutor(new TryPlus());
        //getCommand("discord").setExecutor(new DiscordCommand());
        //getCommand("web").setExecutor(new WebCommand());


        System.out.println(
                "\n" +
                "  _______                                          \n" +
                " |__   __|                                         \n" +
                "    | |_ __ _   _                                  \n" +
                "    | | '__| | | |                                 \n" +
                "    | | |  | |_| |                                 \n" +
                "    |_|_|   \\__, |     _____ _____                \n" +
                "             __/ /\\   |  __ \\_   _|              \n" +
                "            |___/  \\  | |__) || |                 \n" +
                "               / /\\ \\ |  ___/ | |                \n" +
                "              / ____ \\| |    _| |_                \n" +
                "             /_/    \\_\\_|   |_____|              \n" +
                "\n");
        System.out.println("L'API de TryCube à chargée en " + loadTime + "ms !");
        System.out.println("Version de l'API de TryCube: ${project.version}");
        System.out.println("Version du server: " + Bukkit.getVersion());
    }

    @EventHandler
    public void dataLoader(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        if(!cubeData.file.exists()) {
            Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                @Override
                public void run() {
                    cubeData.setNickname(p.getName());
                    cubeData.setRank("Joueur");
                    cubeData.setCoins(50.0);
                    cubeData.setGems(0.0);
                    cubeData.setMod("false");
                    cubeData.setStaff("false");
                    cubeData.optFriendRequest("Everyone");
                    cubeData.optPrivateMessage("Everyone");

                    TeamTags.setNameTag(p, "10", "§7");
                }
            }, 10L);
        }
    }
}
