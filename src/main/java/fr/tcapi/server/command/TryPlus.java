package fr.tcapi.server.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TryPlus implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§3TryCube §f┃ Cette commande n'est pas encore disponible !" );
        return true;
    }
}
