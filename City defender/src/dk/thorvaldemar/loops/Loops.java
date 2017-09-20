package dk.thorvaldemar.loops;

import org.bukkit.scheduler.BukkitRunnable;
import dk.thorvaldemar.Main;

public final class Loops extends BukkitRunnable {
	
	private static Main plugin;

	public Loops(Main pl) {
		plugin = pl;
	}

	public void run() {
		plugin.getConfig();
	}

}