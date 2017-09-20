package dk.thorvaldemar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ProtectCityC implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("pc") || label.equalsIgnoreCase("protectcity")) {
			if (isPlayer(sender)) {
				
				/********************************
				 * 			  Player			*
				 ********************************/
				
				Player p = (Player) sender;
				
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("hall")) {
						p.sendMessage(ChatColor.RED + "You do not have a city yet. \"/ + " + label + " create\" to create a new city");
					}
				} else if (args.length == 0) {
					((Player) sender).sendMessage(ChatColor.RED + "/" + label + " [hall:create:remove:team]");
				} else {
					sender.sendMessage(ChatColor.RED + "To many arguments. \"/" + label + "\" for more help");
				}
			} else {
				
				/********************************
				 * 			 Console			*
				 ********************************/
				
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("")) {

					}
				} else if (args.length == 0) {
					sender.sendMessage(ChatColor.RED + "/" + label + " [remove:team]");
				} else {
					sender.sendMessage(ChatColor.RED + "To many arguments. \"/" + label + "\" for more help");
				}
			}
		}
		return false;
	}

	boolean isPlayer(CommandSender sender) {
		if (sender instanceof Player) {
			return true;
		}
		return false;
	}

}
