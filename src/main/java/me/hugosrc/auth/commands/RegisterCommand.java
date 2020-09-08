package me.hugosrc.auth.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if (args.length != 2) {
            player.sendMessage("§aUse: /register <senha> <confirmar>");
            return false;
        }

        String password = args[0];

        if (!args[0].equals(args[1])) {
            player.sendMessage("§aAs senhas não batem!");
            return false;
        }

        return false;
    }
}
