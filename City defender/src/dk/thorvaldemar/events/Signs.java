package dk.thorvaldemar.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class Signs implements Listener {
	
	@EventHandler
	public void onSignCreate(SignChangeEvent e) {
		
		//Line 0
		e.setLine(0, e.getLine(0).replace("&0", ChatColor.BLACK + ""));
		e.setLine(0, e.getLine(0).replace("&1", ChatColor.DARK_BLUE + ""));
		e.setLine(0, e.getLine(0).replace("&2", ChatColor.DARK_GREEN + ""));
		e.setLine(0, e.getLine(0).replace("&3", ChatColor.DARK_AQUA + ""));
		e.setLine(0, e.getLine(0).replace("&4", ChatColor.DARK_RED + ""));
		e.setLine(0, e.getLine(0).replace("&5", ChatColor.DARK_PURPLE + ""));
		e.setLine(0, e.getLine(0).replace("&6", ChatColor.GOLD + ""));
		e.setLine(0, e.getLine(0).replace("&7", ChatColor.GRAY + ""));
		e.setLine(0, e.getLine(0).replace("&8", ChatColor.DARK_GRAY + ""));
		e.setLine(0, e.getLine(0).replace("&9", ChatColor.BLUE + ""));
		e.setLine(0, e.getLine(0).replace("&a", ChatColor.GREEN + ""));
		e.setLine(0, e.getLine(0).replace("&b", ChatColor.AQUA + ""));
		e.setLine(0, e.getLine(0).replace("&c", ChatColor.RED + ""));
		e.setLine(0, e.getLine(0).replace("&d", ChatColor.LIGHT_PURPLE + ""));
		e.setLine(0, e.getLine(0).replace("&e", ChatColor.YELLOW + ""));
		e.setLine(0, e.getLine(0).replace("&f", ChatColor.WHITE + ""));
		e.setLine(0, e.getLine(0).replace("&k", ChatColor.MAGIC + ""));
		e.setLine(0, e.getLine(0).replace("&l", ChatColor.BOLD + ""));
		e.setLine(0, e.getLine(0).replace("&m", ChatColor.STRIKETHROUGH + ""));
		e.setLine(0, e.getLine(0).replace("&n", ChatColor.UNDERLINE + ""));
		e.setLine(0, e.getLine(0).replace("&o", ChatColor.ITALIC + ""));
		e.setLine(0, e.getLine(0).replace("&r", ChatColor.RESET + ""));
		
		//Line 1
		e.setLine(1, e.getLine(1).replace("&0", ChatColor.BLACK + ""));
		e.setLine(1, e.getLine(1).replace("&1", ChatColor.DARK_BLUE + ""));
		e.setLine(1, e.getLine(1).replace("&2", ChatColor.DARK_GREEN + ""));
		e.setLine(1, e.getLine(1).replace("&3", ChatColor.DARK_AQUA + ""));
		e.setLine(1, e.getLine(1).replace("&4", ChatColor.DARK_RED + ""));
		e.setLine(1, e.getLine(1).replace("&5", ChatColor.DARK_PURPLE + ""));
		e.setLine(1, e.getLine(1).replace("&6", ChatColor.GOLD + ""));
		e.setLine(1, e.getLine(1).replace("&7", ChatColor.GRAY + ""));
		e.setLine(1, e.getLine(1).replace("&8", ChatColor.DARK_GRAY + ""));
		e.setLine(1, e.getLine(1).replace("&9", ChatColor.BLUE + ""));
		e.setLine(1, e.getLine(1).replace("&a", ChatColor.GREEN + ""));
		e.setLine(1, e.getLine(1).replace("&b", ChatColor.AQUA + ""));
		e.setLine(1, e.getLine(1).replace("&c", ChatColor.RED + ""));
		e.setLine(1, e.getLine(1).replace("&d", ChatColor.LIGHT_PURPLE + ""));
		e.setLine(1, e.getLine(1).replace("&e", ChatColor.YELLOW + ""));
		e.setLine(1, e.getLine(1).replace("&f", ChatColor.WHITE + ""));
		e.setLine(1, e.getLine(1).replace("&k", ChatColor.MAGIC + ""));
		e.setLine(1, e.getLine(1).replace("&l", ChatColor.BOLD + ""));
		e.setLine(1, e.getLine(1).replace("&m", ChatColor.STRIKETHROUGH + ""));
		e.setLine(1, e.getLine(1).replace("&n", ChatColor.UNDERLINE + ""));
		e.setLine(1, e.getLine(1).replace("&o", ChatColor.ITALIC + ""));
		e.setLine(1, e.getLine(1).replace("&r", ChatColor.RESET + ""));
		
		//Line 2
		e.setLine(2, e.getLine(2).replace("&0", ChatColor.BLACK + ""));
		e.setLine(2, e.getLine(2).replace("&1", ChatColor.DARK_BLUE + ""));
		e.setLine(2, e.getLine(2).replace("&2", ChatColor.DARK_GREEN + ""));
		e.setLine(2, e.getLine(2).replace("&3", ChatColor.DARK_AQUA + ""));
		e.setLine(2, e.getLine(2).replace("&4", ChatColor.DARK_RED + ""));
		e.setLine(2, e.getLine(2).replace("&5", ChatColor.DARK_PURPLE + ""));
		e.setLine(2, e.getLine(2).replace("&6", ChatColor.GOLD + ""));
		e.setLine(2, e.getLine(2).replace("&7", ChatColor.GRAY + ""));
		e.setLine(2, e.getLine(2).replace("&8", ChatColor.DARK_GRAY + ""));
		e.setLine(2, e.getLine(2).replace("&9", ChatColor.BLUE + ""));
		e.setLine(2, e.getLine(2).replace("&a", ChatColor.GREEN + ""));
		e.setLine(2, e.getLine(2).replace("&b", ChatColor.AQUA + ""));
		e.setLine(2, e.getLine(2).replace("&c", ChatColor.RED + ""));
		e.setLine(2, e.getLine(2).replace("&d", ChatColor.LIGHT_PURPLE + ""));
		e.setLine(2, e.getLine(2).replace("&e", ChatColor.YELLOW + ""));
		e.setLine(2, e.getLine(2).replace("&f", ChatColor.WHITE + ""));
		e.setLine(2, e.getLine(2).replace("&k", ChatColor.MAGIC + ""));
		e.setLine(2, e.getLine(2).replace("&l", ChatColor.BOLD + ""));
		e.setLine(2, e.getLine(2).replace("&m", ChatColor.STRIKETHROUGH + ""));
		e.setLine(2, e.getLine(2).replace("&n", ChatColor.UNDERLINE + ""));
		e.setLine(2, e.getLine(2).replace("&o", ChatColor.ITALIC + ""));
		e.setLine(2, e.getLine(2).replace("&r", ChatColor.RESET + ""));
		
		//Line 3
		e.setLine(3, e.getLine(3).replace("&0", ChatColor.BLACK + ""));
		e.setLine(3, e.getLine(3).replace("&1", ChatColor.DARK_BLUE + ""));
		e.setLine(3, e.getLine(3).replace("&2", ChatColor.DARK_GREEN + ""));
		e.setLine(3, e.getLine(3).replace("&3", ChatColor.DARK_AQUA + ""));
		e.setLine(3, e.getLine(3).replace("&4", ChatColor.DARK_RED + ""));
		e.setLine(3, e.getLine(3).replace("&5", ChatColor.DARK_PURPLE + ""));
		e.setLine(3, e.getLine(3).replace("&6", ChatColor.GOLD + ""));
		e.setLine(3, e.getLine(3).replace("&7", ChatColor.GRAY + ""));
		e.setLine(3, e.getLine(3).replace("&8", ChatColor.DARK_GRAY + ""));
		e.setLine(3, e.getLine(3).replace("&9", ChatColor.BLUE + ""));
		e.setLine(3, e.getLine(3).replace("&a", ChatColor.GREEN + ""));
		e.setLine(3, e.getLine(3).replace("&b", ChatColor.AQUA + ""));
		e.setLine(3, e.getLine(3).replace("&c", ChatColor.RED + ""));
		e.setLine(3, e.getLine(3).replace("&d", ChatColor.LIGHT_PURPLE + ""));
		e.setLine(3, e.getLine(3).replace("&e", ChatColor.YELLOW + ""));
		e.setLine(3, e.getLine(3).replace("&f", ChatColor.WHITE + ""));
		e.setLine(3, e.getLine(3).replace("&k", ChatColor.MAGIC + ""));
		e.setLine(3, e.getLine(3).replace("&l", ChatColor.BOLD + ""));
		e.setLine(3, e.getLine(3).replace("&m", ChatColor.STRIKETHROUGH + ""));
		e.setLine(3, e.getLine(3).replace("&n", ChatColor.UNDERLINE + ""));
		e.setLine(3, e.getLine(3).replace("&o", ChatColor.ITALIC + ""));
		e.setLine(3, e.getLine(3).replace("&r", ChatColor.RESET + ""));
	}
}