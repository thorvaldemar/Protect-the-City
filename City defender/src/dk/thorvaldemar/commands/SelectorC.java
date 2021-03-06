package dk.thorvaldemar.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dk.thorvaldemar.events.Selector;
import dk.thorvaldemar.permissions.Permission;
import net.md_5.bungee.api.ChatColor;

public class SelectorC implements CommandExecutor {

	// # selector # \\

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("selector")) {
			CommandSender p = sender;
			if (Permission.hasPermission(p, "selecotor")) {
				if (args.length == 2) {
					if (args[0].equalsIgnoreCase("add")) {
						if (Bukkit.getPlayer(args[1]) != null) {
							Player to = Bukkit.getPlayer(args[1]);
							if (Selector.addPlayer(to)) {
								to.sendMessage(ChatColor.GREEN + "The selector is now active for you");
								p.sendMessage(ChatColor.GREEN + "The selector is now active for " + ChatColor.DARK_GREEN
										+ to.getName());
							} else {
								p.sendMessage(ChatColor.DARK_RED + to.getName() + ChatColor.RED + " is already active");
							}
						} else {
							p.sendMessage(
									ChatColor.DARK_RED + args[1] + ChatColor.RED + " does not exist or is not online");
						}
					} else if (args[0].equalsIgnoreCase("remove")) {
						if (Bukkit.getPlayer(args[1]) != null) {
							Player to = Bukkit.getPlayer(args[1]);
							if (Selector.removePlayer(to)) {
								to.sendMessage(ChatColor.RED + "The selector is now deactivated for you");
								p.sendMessage(ChatColor.RED + "The selector is now deactivated for "
										+ ChatColor.DARK_RED + to.getName());
							} else {
								p.sendMessage(ChatColor.DARK_RED + to.getName() + ChatColor.RED + " is not active");
							}
						} else {
							p.sendMessage(
									ChatColor.DARK_RED + args[1] + ChatColor.RED + " does not exist or is not online");
						}
					} else {
						p.sendMessage(ChatColor.RED + "Wrong arguments. \"/selector\" for more help");
					}
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("add")) {
						p.sendMessage(ChatColor.RED + "/selector add [Player]");
					} else if (args[0].equalsIgnoreCase("remove")) {
						p.sendMessage(ChatColor.RED + "/selector remove [Player]");
					} else {
						p.sendMessage(ChatColor.RED + "Wrong arguments. \"/selector\" for more help");
					}
				} else if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "/selector [add:remove]");
				} else {
					p.sendMessage(ChatColor.RED + "To many arguments. \"/selector\" for more help");
				}
			} else {
				p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
			}
		}
		return false;
	}

}
