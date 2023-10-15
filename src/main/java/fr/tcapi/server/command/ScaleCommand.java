package fr.tcapi.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ScaleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§3TryCube §f┃ §bhttps://trycubemc.com/#" );
        Player p;
        p = e.getPlayer();
        return true;
    }
}
