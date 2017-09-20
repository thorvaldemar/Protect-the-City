package dk.thorvaldemar.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dk.thorvaldemar.events.Selector;

public class broadcastTitle implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("bct")) {
			if (args.length >= 1) {
				String str = "";
				for (int i = 0; i < args.length; i++) {
					str += args[i] + " ";
				}
				for (Player player : Bukkit.getOnlinePlayers()) {
					player.sendTitle(ChatColor.GOLD + "[" + ChatColor.DARK_RED + "Broadcast" + ChatColor.GOLD + "]", ChatColor.GREEN + str, 15, 100, 15);
				}
			} else if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "/bct [args...]");
				Selector.removeAllShulkers(p);
			}
			return false;
		}
		return false;
	}
	
}
