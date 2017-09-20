package dk.thorvaldemar.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dk.thorvaldemar.Main;
import dk.thorvaldemar.configs.Config;

public class FTJoin implements Listener {

	@EventHandler
	public void onFirstJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		Config userData = Main.userData;
		
		if (!Main.userData.get().contains(p.getName())) {
			userData.get().set(p.getName() + ".hasCity", false);
			userData.get().set(p.getName() + ".cityName", "null");
		}
		
	}
	
}
