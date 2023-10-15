package fr.tcapi.others.data;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Random;

public class TryCubeDataManager {

    public static void gainCoins(Player p) {
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        Random rdm = new Random();
        double rdmR = rdm.nextDouble();

        double minValue = 0.5;
        double maxValue = 3.0;
        double scaledValue = minValue + (rdmR * (maxValue - minValue));

        cubeData.setCoins(cubeData.getCoins() + scaledValue);
        Bukkit.broadcastMessage(ChatColor.GREEN + "§3Piñata §f┃ Vous avez gagné §b" + scaledValue + "§f Pièces !");
    }

    public static void gainPinataCoins(Player p) {
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        Random rdm = new Random();
        double rdmR = rdm.nextDouble();

        double minValue = 75.0;
        double maxValue = 150.0;
        double scaledValue = minValue + (rdmR * (maxValue - minValue));

        cubeData.setCoins(cubeData.getCoins() + scaledValue);
        Bukkit.broadcastMessage(ChatColor.GREEN + "§3Piñata §f┃ Vous avez gagné §b" + scaledValue + " §fPièces grâce à la Piñata !");
    }

    public static String convertCoin(Player p) {
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        if(cubeData.getCoins() >= 1000) {
            return cubeData.getCoins() / 1000 + "k";
        } else if(cubeData.getCoins() >= 1000000) {
            return cubeData.getCoins() / 1000000 + "m";
        } else if(cubeData.getCoins() >= 1000000000) {
            return cubeData.getCoins() / 1000000000 + "Md";
        }
        return String.valueOf(cubeData.getCoins());
    }

    public static void gainPinataGems(Player p) {
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        Random rdm = new Random();
        double rdmR = rdm.nextDouble();

        double minValue = 5.0;
        double maxValue = 10.0;
        double scaledValue = minValue + (rdmR * (maxValue - minValue));

        cubeData.setCoins(cubeData.getCoins() + scaledValue);
        Bukkit.broadcastMessage(ChatColor.GREEN + "&3Pinata &f┃ Vous avez gagné §b" + scaledValue + " §fGemmes grâce à la Piñata !");
    }

    public static String convertGems(Player p) {
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        if(cubeData.getGems() >= 1000) {
            return cubeData.getGems() / 1000 + "k";
        } else if(cubeData.getGems() >= 1000000) {
            return cubeData.getGems() / 1000000 + "m";
        } else if(cubeData.getGems() >= 1000000000) {
            return cubeData.getGems() / 1000000000 + "Md";
        }
        return String.valueOf(cubeData.getGems());
    }

    public static void changeParameter(Player p, String parameterType) {
        TryCubeData cubeData = new TryCubeData(p.getUniqueId());
        if(parameterType.equals("FriendRequest")) {
            if(cubeData.getOptFR().equals("Everyone")) {
                cubeData.optFriendRequest("Nobody");
            } else if(cubeData.getOptFR().equals("Nobody")) {
                cubeData.optFriendRequest("Everyone");
            }
        } else if(parameterType.equals("PrivateMessage")) {
            if(cubeData.getOptFR().equals("Everyone")) {
                cubeData.optFriendRequest("Friend Only");
            } else if(cubeData.getOptFR().equals("Friend Only")) {
                cubeData.optFriendRequest("Nobody");
            } else if(cubeData.getOptFR().equals("Nobody")) {
                cubeData.optFriendRequest("Everyone");
            }
        }
    }

}
