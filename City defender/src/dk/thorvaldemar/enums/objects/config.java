package dk.thorvaldemar.enums.objects;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.bukkit.configuration.file.YamlConfiguration;

import dk.thorvaldemar.Main;

public class config {

	private Main plugin;
	
	private String name;
	
	public File file = new File(plugin.getDataFolder(), name + ".yml");
	public org.bukkit.configuration.file.FileConfiguration config = YamlConfiguration
			.loadConfiguration(new File(plugin.getDataFolder(), name + ".yml"));
	
	public config(String name, Main pl) {
		this.plugin = pl;
		this.name = name;
	}
	
	public void reload() {
		if (file == null) {
			file = new File(plugin.getDataFolder(), name + ".yml");
		}
		config = YamlConfiguration.loadConfiguration(file);

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
		if (config == null || file == null) {
			return;
		}
		try {
			get().save(file);
		} catch (IOException ex) {
			plugin.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
		}
	}
	
}
