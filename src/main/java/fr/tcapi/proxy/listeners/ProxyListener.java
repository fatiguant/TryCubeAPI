package fr.tcapi.proxy.listeners;

import fr.tcapi.others.Titles;
import fr.tcapi.proxy.BungeeMain;
import fr.tcapi.others.data.TryCubeData;
import net.md_5.bungee.api.Title;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyListener implements Listener {

    @EventHandler
    public void onPlayerLogin(ServerConnectEvent e) {
        ProxiedPlayer p = e.getPlayer();

        Title t = BungeeMain.getInstance().getProxy().createTitle();
        Titles.sendProxyTitle(p, "§3Try§fCube", "§3§ki§f Bon jeu " + p.getName() + " §3§ki", 3, 60, 3);
        p.sendTitle(t);
    }
}
