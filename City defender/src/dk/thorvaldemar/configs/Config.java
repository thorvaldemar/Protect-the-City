package dk.thorvaldemar.configs;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.bukkit.configuration.file.YamlConfiguration;

import dk.thorvaldemar.Main;

public class Config {
	
	private Main plugin;
	String name;
	
	public File File;
	public org.bukkit.configuration.file.FileConfiguration config;
	
	public Config(Main pl, String name) {
		plugin = pl;
		this.name = name;
		File = new File(plugin.getDataFolder(), name + ".yml");
		config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), name + ".yml"));
		System.out.println(name + ".yml");
		save();
	}
	
	public void reload() {
		if (File == null) {
			File = new File(plugin.getDataFolder(), name + ".yml");
		}
		config = YamlConfiguration.loadConfiguration(File);

		// Look for defaults in the jar
		Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(plugin.getResource(name + ".yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			config.setDefaults(defConfig);
		}
	}

	public org.bukkit.configuration.file.FileConfiguration get() {
		if (config == null) {
			reload();
		}
		return config;
	}

	public void save() {
		if (config == null || File == null) {
			return;
		}
		try {
			get().save(File);
		} catch (IOException ex) {
			plugin.getLogger().log(Level.SEVERE, "Could not save " + name + " to " + File, ex);
		}
	}
	
}
