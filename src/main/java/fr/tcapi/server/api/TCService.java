package fr.tcapi.server.api;

import be.alexandre01.dnplugin.plugins.spigot.api.DNSpigotAPI;

public class TCService {

    static DNSpigotAPI trySpigot = DNSpigotAPI.getInstance();

    public static int loadID() {
        return trySpigot.getID();
    }

    public static String loadHostname() {
        return trySpigot.getServerName() + "#" + trySpigot.getID();
    }

    public static int loadNetwork() {
        return trySpigot.getDnPlayerManager().getDnPlayers().size();
    }

    public static int loadList(String parameters) {
        return trySpigot.getByName(parameters).getPlayers().size();
    }

    public static int loadSpecific(String parameters, Integer parameters2) {
        return trySpigot.getByName(parameters).getServers().get(parameters2).getPlayers().size();
    }
}
