package fr.tcapi.server.integration;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;

public class TeamTags {
    private String prefix;
    private String suffix;
    private Team team;
    public static Scoreboard scoreboard;

    public TeamTags(String name, String prefix, String suffix, Scoreboard current) throws Exception {
        this.prefix = prefix;
        this.suffix = suffix;
        this.team = current.getTeam(name);
        if (this.team == null) {
            this.team = current.registerNewTeam(name);
        }

        scoreboard = current;
        this.team.setCanSeeFriendlyInvisibles(false);
        this.team.setAllowFriendlyFire(false);
        int prefixLength = 0;
        int suffixLength = 0;
        if (prefix != null) {
            prefixLength = prefix.length();
        }

        if (suffix != null) {
            suffixLength = suffix.length();
        }

        if (prefixLength + suffixLength >= 32) {
            throw new Exception("prefix and suffix lenghts are greater than 16");
        } else {
            if (suffix != null) {
                this.team.setSuffix(ChatColor.translateAlternateColorCodes('&', suffix));
            }

            if (prefix != null) {
                this.team.setPrefix(ChatColor.translateAlternateColorCodes('&', prefix));
            }

        }
    }

    public TeamTags(String name, String prefix, String suffix) throws Exception {
        this(name, prefix, suffix, Bukkit.getScoreboardManager().getMainScoreboard());
    }

    public static void setNameTag(Player player, String name, String prefix, boolean badges) {
        try {
            if(badges) {
                TeamTags tag = new TeamTags(name, prefix, "§7 ▏ §a✔");
                tag.set(player);
            } else {
                TeamTags tag = new TeamTags(name, prefix, (String)null);
                tag.set(player);
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public void set(Player player) {
        this.team.addPlayer(player);
        player.setScoreboard(scoreboard);
    }

    public void remove(Player player) {
        this.team.removePlayer(player);
    }

    public void resetTagUtils(UUID uuid) {
        this.remove(Bukkit.getPlayer(uuid));
    }

    public void setAll(Collection<Player> players) {
        Iterator var2 = players.iterator();

        while(var2.hasNext()) {
            Player player = (Player)var2.next();
            this.set(player);
        }

    }

    public void setAll(Player[] players) {
        Player[] arrayOfPlayer = players;
        int j = players.length;

        for(int i = 0; i < j; ++i) {
            Player player = arrayOfPlayer[i];
            this.set(player);
        }

    }

    public void setPrefix(String prefix) {
        this.prefix = ChatColor.translateAlternateColorCodes('&', prefix);
        this.team.setPrefix(this.prefix);
    }

    public void setSuffix(String suffix) {
        this.suffix = ChatColor.translateAlternateColorCodes('&', suffix);
        this.team.setSuffix(this.suffix);
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public Team getTeam() {
        return this.team;
    }

    public void removeTeam() {
        this.team.unregister();
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public static void setNameTag(Player player, String name, String prefix) {
        try {
            TeamTags tag = new TeamTags(name, prefix, (String)null);
            tag.set(player);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}