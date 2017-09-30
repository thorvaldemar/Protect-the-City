package dk.thorvaldemar.enums.functions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import dk.thorvaldemar.Main;
import dk.thorvaldemar.permissions.Permission;

public class Chat implements Listener {
	
	// # chat.color # \\
	// # chat.prefix # \\
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		Player p = e.getPlayer();
		
		//e.setCancelled(true);
		
		if (Permission.hasPermission(p, "chat.prefix")) {
			// permissions
			String changed = getPrefix(Main.playerPerms.get().getString(p.getName() + ".rank"));
			e.setFormat(changed + ChatColor.DARK_GRAY + " %s: %s");
		} else {
			e.setFormat(ChatColor.DARK_GRAY + "%s: %s");
		}
		
		if (Permission.hasPermission(p, "chat.color")) {
			e.setMessage(e.getMessage().replace("&0", ChatColor.BLACK + ""));
			e.setMessage(e.getMessage().replace("&1", ChatColor.DARK_BLUE + ""));
			e.setMessage(e.getMessage().replace("&2", ChatColor.DARK_GREEN + ""));
			e.setMessage(e.getMessage().replace("&3", ChatColor.DARK_AQUA + ""));
			e.setMessage(e.getMessage().replace("&4", ChatColor.DARK_RED + ""));
			e.setMessage(e.getMessage().replace("&5", ChatColor.DARK_PURPLE + ""));
			e.setMessage(e.getMessage().replace("&6", ChatColor.GOLD + ""));
			e.setMessage(e.getMessage().replace("&7", ChatColor.GRAY + ""));
			e.setMessage(e.getMessage().replace("&8", ChatColor.DARK_GRAY + ""));
			e.setMessage(e.getMessage().replace("&9", ChatColor.BLUE + ""));
			e.setMessage(e.getMessage().replace("&a", ChatColor.GREEN + ""));
			e.setMessage(e.getMessage().replace("&b", ChatColor.AQUA + ""));
			e.setMessage(e.getMessage().replace("&c", ChatColor.RED + ""));
			e.setMessage(e.getMessage().replace("&d", ChatColor.LIGHT_PURPLE + ""));
			e.setMessage(e.getMessage().replace("&e", ChatColor.YELLOW + ""));
			e.setMessage(e.getMessage().replace("&f", ChatColor.WHITE + ""));
			e.setMessage(e.getMessage().replace("&k", ChatColor.MAGIC + ""));
			e.setMessage(e.getMessage().replace("&l", ChatColor.BOLD + ""));
			e.setMessage(e.getMessage().replace("&m", ChatColor.STRIKETHROUGH + ""));
			e.setMessage(e.getMessage().replace("&n", ChatColor.UNDERLINE + ""));
			e.setMessage(e.getMessage().replace("&o", ChatColor.ITALIC + ""));
			e.setMessage(e.getMessage().replace("&r", ChatColor.RESET + ""));
		} else {
			//p.sendMessage(ChatColor.RED + "You do not have the permission to write with color");
		}
	}
	
	public static String getPrefix(String rank) {
		String prefix = changeToColor(Main.permissions.get().getString("Ranks." + rank + ".options.prefix"));;
		return prefix;
	}
	
	public static String changeToColor(String str) {
		//str = str.replace("&2", ChatColor.DARK_GREEN + "");
		str = str.replace("&0", ChatColor.BLACK + "");
		str = str.replace("&1", ChatColor.DARK_BLUE + "");
		str = str.replace("&2", ChatColor.DARK_GREEN + "");
		str = str.replace("&3", ChatColor.DARK_AQUA + "");
		str = str.replace("&4", ChatColor.DARK_RED + "");
		str = str.replace("&5", ChatColor.DARK_PURPLE + "");
		str = str.replace("&6", ChatColor.GOLD + "");
		str = str.replace("&7", ChatColor.GRAY + "");
		str = str.replace("&8", ChatColor.DARK_GRAY + "");
		str = str.replace("&9", ChatColor.BLUE + "");
		str = str.replace("&a", ChatColor.GREEN + "");
		str = str.replace("&b", ChatColor.AQUA + "");
		str = str.replace("&c", ChatColor.RED + "");
		str = str.replace("&d", ChatColor.LIGHT_PURPLE + "");
		str = str.replace("&e", ChatColor.YELLOW + "");
		str = str.replace("&f", ChatColor.WHITE + "");
		str = str.replace("&k", ChatColor.MAGIC + "");
		str = str.replace("&l", ChatColor.BOLD + "");
		str = str.replace("&m", ChatColor.STRIKETHROUGH + "");
		str = str.replace("&n", ChatColor.UNDERLINE + "");
		str = str.replace("&o", ChatColor.ITALIC + "");
		str = str.replace("&r", ChatColor.RESET + "");
		return str;
	}
	
}