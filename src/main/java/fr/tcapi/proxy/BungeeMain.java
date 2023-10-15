package fr.tcapi.proxy;

import fr.tcapi.proxy.listeners.ProxyListener;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeeMain extends Plugin {

    @Getter
    private static BungeeMain instance;

    @Override
    public void onEnable() {
        instance = this;

        getProxy().getPluginManager().registerListener(this, new ProxyListener());
    }
}
