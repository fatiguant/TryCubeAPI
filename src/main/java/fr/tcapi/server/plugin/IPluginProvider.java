package fr.tcapi.server.plugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
public interface IPluginProvider {

    JavaPlugin getPlugin();

    String getId();

    String[] getCommandsPackages();

    String[] getListenersPackages();

    String[] getItemsPackages();

    String getLanguagesPath();

    default Logger getLogger() {
        return this.getPlugin().getLogger();
    }

}