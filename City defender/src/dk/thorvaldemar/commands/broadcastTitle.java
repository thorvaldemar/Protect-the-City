package dk.thorvaldemar.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dk.thorvaldemar.enums.functions.Chat;
import dk.thorvaldemar.permissions.Permission;

public class broadcastTitle implements CommandExecutor {

	// # broadcast # \\

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		CommandSender p = sender;
		if (label.equalsIgnoreCase("bct")) {
			if (Permission.hasPermission(p, "broadcast")) {
				if (args.length >= 1) {
					String str = "";
					for (int i = 0; i < args.length; i++) {
						if (args[i].contains("&")) {
							str += Chat.changeToColor(args[i]) + " " + ChatColor.GREEN;
						} else {
							str += args[i] + " ";
						}
					}
					for (Player player : Bukkit.getOnlinePlayers()) {
						player.sendTitle(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Broadcast" + ChatColor.GOLD + "]",
								ChatColor.GREEN + str, 15, 100, 15);
					}
					Bukkit.broadcastMessage(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Broadcast" + ChatColor.GOLD
							+ "] " + ChatColor.GREEN + str);
				} else if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "/bct [args...]");
				}
				return false;
			} else {
				p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
			}
		}
		return false;
	}

}
