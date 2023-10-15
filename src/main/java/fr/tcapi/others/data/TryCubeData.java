package fr.tcapi.others.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class TryCubeData {

    private UUID uuid;
    public File file;
    private FileConfiguration configFile;

    public TryCubeData(UUID uuid) {
        this.uuid = uuid;
        setupPlayerFile();
    }

    private void setupPlayerFile() {
        file = new File("../../../TryCube/Data/" + uuid + ".yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public void savePlayerFile() {
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void setNickname(String name) { // set une variable
        configFile.set("Nickname", name);
        savePlayerFile();
    }
    public void setRank(String rank) { // set une variable
        configFile.set("Rank", rank);
        savePlayerFile();
    }
    public void setMod(String mod) { // set une variable
        configFile.set("ModerationMod", mod);
        savePlayerFile();
    }
    public void setStaff(String staff) { // set une variable
        configFile.set("StaffPerm", staff);
        savePlayerFile();
    }

    public void setCoins(double coins) {
        configFile.set("Coins", coins);
        savePlayerFile();
    }
    public void setGems(double gems) {
        configFile.set("Gems", gems);
        savePlayerFile();
    }

    public void optFriendRequest(String frequest) {
        configFile.set("OptionsFriendRequest", frequest);
    }
    public void optPrivateMessage(String pm) {
        configFile.set("OptionsPrivateMessage", pm);
    }

    public String getNickname() {
        return configFile.getString("ServerName");
    }
    public String getRank() {
        return configFile.getString("Rank");
    }
    public String getStaff() {
        return configFile.getString("StaffPerm");
    }
    public String getMod() {
        return configFile.getString("ModerationMod");
    }
    public int getCoins() {
        return configFile.getInt("Coins");
    }
    public int getGems() {
        return configFile.getInt("Gems");
    }

    public String getOptFR() {
        return configFile.getString("OptionsFriendRequest");
    }
    public String getOptPM() {
        return configFile.getString("OptionsPrivateMessage");
    }

}