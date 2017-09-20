package dk.thorvaldemar.enums.functions;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener {
	
	/*private Main plugin;

	public Chat(Main pl) {
		plugin = pl;
	}*/
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		
		//Player p = e.getPlayer();
		
		/*if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("rekrut")) 
				e.setFormat(ChatColor.WHITE + "" +  ChatColor.BOLD + "Rekrut" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("soldat")) 
				e.setFormat(ChatColor.DARK_BLUE + "" +  ChatColor.BOLD + "Soldat" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("general")) 
				e.setFormat(ChatColor.YELLOW + "" +  ChatColor.BOLD + "General" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("officer")) 
				e.setFormat(ChatColor.DARK_RED + "" +  ChatColor.BOLD + "Officer" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("flopper")) 
				e.setFormat(ChatColor.GOLD + "" +  ChatColor.BOLD + "Flopper" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("admin")) 
				e.setFormat(ChatColor.DARK_AQUA + "" +  ChatColor.BOLD + "Admin" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("tekniker")) 
				e.setFormat(ChatColor.GREEN + "" +  ChatColor.BOLD + "Tekniker" + ChatColor.DARK_GRAY + " %s: %s");
		
		if (plugin.getConfig().getString(p.getName() + "-rank").equalsIgnoreCase("megasejeowner")) 
				e.setFormat(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "MegaSejeOwner" + ChatColor.DARK_GRAY + " %s: %s");*/
		
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
	}
}