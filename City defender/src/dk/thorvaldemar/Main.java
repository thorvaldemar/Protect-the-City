package dk.thorvaldemar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import dk.thorvaldemar.commands.ProtectCityC;
import dk.thorvaldemar.commands.SelectorC;
import dk.thorvaldemar.commands.broadcastTitle;
import dk.thorvaldemar.commands.renameItemC;
import dk.thorvaldemar.configs.Config;
import dk.thorvaldemar.enums.functions.Chat;
import dk.thorvaldemar.events.PlayerJoin;
import dk.thorvaldemar.events.Selector;
import dk.thorvaldemar.events.Signs;
import dk.thorvaldemar.loops.Loops;
import dk.thorvaldemar.loops.ScoreboardLoop;
import dk.thorvaldemar.permissions.PermissionsC;

public class Main extends JavaPlugin {

	Loops loop;
	ScoreboardLoop scoreboardLoops;
	
	public static Config Cities;
	public static Config userData;
	public static Config permissions;
	public static Config playerPerms;

	public void onEnable() {
		// name = (HashMap<Block, Towers>) load(new File(getDataFolder(),
		// "NameStats.dat"));

		Cities = new Config(this, "CitiesList");
		userData = new Config(this, "userData");
		permissions = new Config(this, "permissions");
		playerPerms = new Config(this, "playerPermissions");
		
		registerCommands();
		registerEvents();
		registerConfig();

		loop = new Loops(this);
		loop.runTaskTimer(this, 0, 1);

		scoreboardLoops = new ScoreboardLoop(this);
		scoreboardLoops.runTaskTimer(this, 0, 20);
		
	}
	
	public void onDisable() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			Selector.removeAllShulkers(p);
		}
	}

	public static boolean hasCity(Player p) {
		if (userData.get().getBoolean(p.getName() + ".hasCity"))
			return true;
		return false;
	}
	
	public void registerCommands() {
		getCommand("bct").setExecutor(new broadcastTitle());
		getCommand("selector").setExecutor(new SelectorC());
		getCommand("pc").setExecutor(new ProtectCityC());
		getCommand("protectcity").setExecutor(new ProtectCityC());
		getCommand("permissions").setExecutor(new PermissionsC());
		getCommand("renameitem").setExecutor(new renameItemC());
		
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		//Functions
		pm.registerEvents(new Chat(), this);
		
		// Events
		pm.registerEvents(new Signs(), this);
		pm.registerEvents(new Selector(), this);
		pm.registerEvents(new PlayerJoin(), this);
		
	}

	public void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
