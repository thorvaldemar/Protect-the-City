package dk.thorvaldemar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import dk.thorvaldemar.enums.functions.Chat;
import dk.thorvaldemar.permissions.Permission;
import net.md_5.bungee.api.ChatColor;

public class renameItemC implements CommandExecutor {

	// # renameitem

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("renameitem")) {
			if (Permission.hasPermission(p, "renameitem")) {
				if (args.length >= 1) {
					String str = "";
					for (int i = 0; i < args.length; i++) {
						if (!(i == args.length - 1)) {
							str += Chat.changeToColor(args[i]) + " ";
						} else {
							str += Chat.changeToColor(args[i]);
						}
					}

					if (p.getInventory().getItemInMainHand() != null) {
						ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
						meta.setDisplayName(Chat.changeToColor(str));
						p.getInventory().getItemInMainHand().setItemMeta(meta);
						p.sendMessage(ChatColor.GOLD + "Items name has been changed to " + ChatColor.WHITE + "\""
								+ Chat.changeToColor(str) + ChatColor.WHITE + "\"");
					} else {
						p.sendMessage(ChatColor.RED + "You need to have the item in your main hand");
					}

				} else if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "/renameitem [args...]");
				}
			} else {
				p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
			}
		}
		return false;
	}

}
