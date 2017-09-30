package dk.thorvaldemar.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import dk.thorvaldemar.Main;
import dk.thorvaldemar.configs.Config;
import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "-" + ChatColor.DARK_GRAY + "] " + p.getName());
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GREEN + "+" + ChatColor.DARK_GRAY + "] " + p.getName());
		
		Config userData = Main.userData;
		Config pPerm = Main.playerPerms;

		if (!Main.userData.get().contains(p.getName())) {
			userData.get().set(p.getName() + ".hasCity", false);
			userData.get().set(p.getName() + ".cityAdmin", false);
			userData.get().set(p.getName() + ".cityName", "null");
			userData.save();
			e.setJoinMessage(ChatColor.GREEN + p.getName() + ChatColor.BLUE + " just joined the server for the first time");
		}

		if (!Main.playerPerms.get().contains(p.getName())) {
			pPerm.get().set(p.getName() + ".rank", "member");
			String[] personalPermissions = { "chat.prefix" };
			pPerm.get().set(p.getName() + ".personalPermissions", personalPermissions);
			pPerm.save();
		}

	}

}
