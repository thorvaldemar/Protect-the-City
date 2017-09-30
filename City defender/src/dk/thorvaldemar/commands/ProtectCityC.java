package dk.thorvaldemar.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dk.thorvaldemar.Main;
import dk.thorvaldemar.permissions.Permission;
import net.md_5.bungee.api.ChatColor;

public class ProtectCityC implements CommandExecutor {

	// # protectcity.hall
	// # protectcity.control
	// # protectcity.team
	
	//To piger en kage
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("pc") || label.equalsIgnoreCase("protectcity")) {
			if (isPlayer(sender)) {
				
				/********************************
				 * 			  Player			*
				 ********************************/
				
				Player p = (Player) sender;
				
				if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("hall")) {
						if (!Permission.hasPermission(p, "protectcity.hall")) {
							p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
							return false;
						}
					} else if (args[0].equalsIgnoreCase("create")) {
						if (!Permission.hasPermission(p, "protectcity.control")) {
							p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
							return false;
						}
					} else if (args[0].equalsIgnoreCase("remove")) {
						if (!Permission.hasPermission(p, "protectcity.control")) {
							p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
							return false;
						}
					}  else if (args[0].equalsIgnoreCase("team")) {
						if (!Permission.hasPermission(p, "protectcity.team")) {
							p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
							return false;
						}
					}
				} else if (args.length == 0) {
					if (!Permission.hasPermission(p, "protectcity.hall") &&
							!Permission.hasPermission(p, "protectcity.control") &&
							!Permission.hasPermission(p, "protectcity.team")) {
						p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
						return false;
					}
				}
				
				if (args.length == 2) {
					
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("hall")) {
						if (Main.hasCity(p)) {
							World world = Bukkit.getWorld(Main.Cities.get().getString(Main.userData.get().getString(p.getName() + ".cityName") + ".world"));
							double x = Main.Cities.get().getDouble(Main.userData.get().getString(p.getName() + ".cityName") + ".x");
							double y = Main.Cities.get().getDouble(Main.userData.get().getString(p.getName() + ".cityName") + ".y");
							double z = Main.Cities.get().getDouble(Main.userData.get().getString(p.getName() + ".cityName") + ".z");
							
							Location cityHallLocation = new Location(world, x, y, z);
							p.teleport(cityHallLocation);
							p.sendMessage(ChatColor.GOLD + "You have been sent home to your city");
						} else {
							p.sendMessage(ChatColor.RED + "You do not have a city yet. \"/" + label + " create\" to create a new city");
						}
					} else if (args[0].equalsIgnoreCase("create")) {
						if (!Main.hasCity(p)) {
							p.sendMessage(ChatColor.RED + "/" + label + " [CityName]");
						} else {
							p.sendMessage(ChatColor.RED + "You can't create a new city, while you are member of another town");
						}
					} else if (args[0].equalsIgnoreCase("remove")) {
						if (Main.hasCity(p)) {
							if (Main.userData.get().getBoolean(p.getName() + ".cityAdmin")) {
								/*
								 * 
								 * Remove the city!
								 * 
								 */
								p.sendMessage(ChatColor.GREEN + "Your city has been removed, and all your teamates has been kicked");
							} else {
								p.sendMessage(ChatColor.RED + "You are not high enough rank in this city to remove it");
							}
						} else {
							p.sendMessage(ChatColor.RED + "You are not member of a city");
						}
					} else if (args[0].equalsIgnoreCase("team")) {
						p.sendMessage(ChatColor.RED + "/" + label + " team [kick:join:invite:freinds:leave]");
					} else {
						p.sendMessage(ChatColor.RED + "Wrong arguments. \"/" + label + "\" for more help");
					}
				} else if (args.length == 0) {
					((Player) sender).sendMessage(ChatColor.RED + "/" + label + " [hall:create:remove:team]");
				} else {
					sender.sendMessage(ChatColor.RED + "To many arguments. \"/" + label + "\" for more help");
				}
			} else {
				
				/********************************
				 * 			 Console			*
				 ********************************/
				
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("")) {

					}
				} else if (args.length == 0) {
					sender.sendMessage(ChatColor.RED + "/" + label + " [remove:team]");
				} else {
					sender.sendMessage(ChatColor.RED + "To many arguments. \"/" + label + "\" for more help");
				}
			}
		}
		return false;
	}
	
	boolean isPlayer(CommandSender sender) {
		if (sender instanceof Player) {
			return true;
		}
		return false;
	}

}
