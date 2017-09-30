package dk.thorvaldemar.permissions;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import dk.thorvaldemar.Main;
import dk.thorvaldemar.enums.functions.Chat;

public class PermissionsC implements CommandExecutor {

	// # permissions.set
	// # permissions.players
	// # permissions.ranks

	public boolean onCommand(CommandSender p, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("permissions")) {

			/*
			 * Permission check
			 */

			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("set")) {
					if (!Permission.hasPermission(p, "permissions.set")) {
						p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
						return false;
					}
				} else if (args[0].equalsIgnoreCase("players")) {
					if (!Permission.hasPermission(p, "permissions.players")) {
						p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
						return false;
					}
				} else if (args[0].equalsIgnoreCase("ranks")) {
					if (!Permission.hasPermission(p, "permissions.ranks")) {
						p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
						return false;
					}
				}
			} else if (args.length == 0) {
				if (!Permission.hasPermission(p, "permissions.set") &&
						!Permission.hasPermission(p, "permissions.players") &&
						!Permission.hasPermission(p, "permissions.ranks")) {
					p.sendMessage(ChatColor.DARK_RED + "You do not have permission to this command");
					return false;
				}
			}

			/*
			 * Command
			 */

			if (args.length == 4) {
				if (args[0].equalsIgnoreCase("players")) {
					if (Bukkit.getPlayer(args[1]) != null) {
						Player to = Bukkit.getPlayer(args[1]);
						if (args[2].equalsIgnoreCase("add")) {
							List<String> perms = Main.playerPerms.get()
									.getStringList(to.getName() + ".personalPermissions");
							if (!perms.contains(args[3])) {
								perms.add(args[3]);
								Main.playerPerms.get().set(to.getName() + ".personalPermissions", perms);
								Main.playerPerms.save();
								p.sendMessage(ChatColor.LIGHT_PURPLE + "You have added the permission "
										+ ChatColor.DARK_PURPLE + args[3] + ChatColor.LIGHT_PURPLE + " to the player "
										+ ChatColor.DARK_PURPLE + to.getName());
								to.sendMessage(ChatColor.DARK_PURPLE + args[3] + ChatColor.LIGHT_PURPLE
										+ " has been added to your permissions");
							} else {
								p.sendMessage(ChatColor.DARK_RED + args[3] + ChatColor.RED
										+ " already exist in the permissions of " + ChatColor.DARK_RED + args[1]);
							}
						} else if (args[2].equalsIgnoreCase("remove")) {
							List<String> perms = Main.playerPerms.get()
									.getStringList(to.getName() + ".personalPermissions");
							if (perms.contains(args[3].toLowerCase())) {
								perms.remove(args[3]);
								Main.playerPerms.get().set(to.getName() + ".personalPermissions", perms);
								Main.playerPerms.save();
								p.sendMessage(ChatColor.LIGHT_PURPLE + "You have removed the permission "
										+ ChatColor.DARK_PURPLE + args[3] + ChatColor.LIGHT_PURPLE + " from the player "
										+ ChatColor.DARK_PURPLE + to.getName());
								to.sendMessage(ChatColor.DARK_PURPLE + args[3] + ChatColor.LIGHT_PURPLE
										+ " has been removed from your permissions");
							} else {
								p.sendMessage(ChatColor.DARK_RED + p.getName() + ChatColor.RED
										+ "does not have the permission " + ChatColor.DARK_RED + args[3]);
							}
						} else {
							p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
						}
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + ChatColor.RED
								+ " is either not online, or does not exist");
					}
				} else if (args[0].equalsIgnoreCase("ranks")) {
					if (Main.permissions.get().contains("Ranks." + args[1].toLowerCase())) {
						if (args[2].equalsIgnoreCase("add")) {
							List<String> perms = Main.permissions.get()
									.getStringList("Ranks." + args[1] + ".permissions");
							if (!perms.contains(args[3].toLowerCase())) {
								perms.add(args[3].toLowerCase());
								Main.permissions.get().set("Ranks." + args[1] + ".permissions", perms);
								Main.permissions.save();
								p.sendMessage(ChatColor.LIGHT_PURPLE + "You have added the permission "
										+ ChatColor.DARK_PURPLE + args[3] + ChatColor.LIGHT_PURPLE + " to the rank "
										+ ChatColor.DARK_PURPLE + args[1]);
							} else {
								p.sendMessage(ChatColor.DARK_RED + args[3] + ChatColor.RED
										+ " already exist in the rank " + ChatColor.DARK_RED + args[1]);
							}
						} else if (args[2].equalsIgnoreCase("remove")) {
							List<String> perms = Main.permissions.get()
									.getStringList("Ranks." + args[1] + ".permissions");
							if (perms.contains(args[3].toLowerCase())) {
								perms.remove(args[3].toLowerCase());
								Main.permissions.get().set("Ranks." + args[1] + ".permissions", perms);
								Main.permissions.save();
								p.sendMessage(ChatColor.LIGHT_PURPLE + "You have removed the permission "
										+ ChatColor.DARK_PURPLE + args[3] + ChatColor.LIGHT_PURPLE + " from the rank "
										+ ChatColor.DARK_PURPLE + args[1]);
							} else {
								p.sendMessage(ChatColor.DARK_RED + args[3] + ChatColor.RED
										+ " does not exist in the rank " + ChatColor.DARK_RED + args[1]);
							}
						} else {
							p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
						}
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + ChatColor.RED + " is not a registeret rank");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("players")) {
					if (Bukkit.getPlayer(args[1]) != null) {
						Player to = Bukkit.getPlayer(args[1]);
						if (args[2].equalsIgnoreCase("add")) {
							p.sendMessage(ChatColor.RED + "/permissions players " + to.getName() + " add [permission]");
						} else if (args[2].equalsIgnoreCase("remove")) {
							p.sendMessage(
									ChatColor.RED + "/permissions players " + to.getName() + " remove [permission]");
						} else if (args[2].equalsIgnoreCase("list")) {
							p.sendMessage(ChatColor.GOLD + "permissions for the player " + args[1] + ":");
							List<String> perms = Main.playerPerms.get()
									.getStringList(to.getName() + ".personalPermissions");
							for (String perm : perms) {
								p.sendMessage(ChatColor.YELLOW + "        - " + perm);
							}
						} else {
							p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
						}
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + ChatColor.RED
								+ " is either not online, or does not exist");
					}
				} else if (args[0].equalsIgnoreCase("ranks")) {
					if (Main.permissions.get().contains("Ranks." + args[1].toLowerCase())) {
						if (args[2].equalsIgnoreCase("add")) {
							p.sendMessage(ChatColor.RED + "/permissions ranks " + args[1] + " add [permission]");
						} else if (args[2].equalsIgnoreCase("remove")) {
							p.sendMessage(ChatColor.RED + "/permissions ranks " + args[1] + " remove [permission]");
						} else if (args[2].equalsIgnoreCase("list")) {
							p.sendMessage(ChatColor.GOLD + "permissions for the rank " + args[1] + ":");
							List<String> perms = Main.permissions.get()
									.getStringList("Ranks." + args[1] + ".permissions");
							for (String perm : perms) {
								p.sendMessage(ChatColor.YELLOW + "        - " + perm);
							}
						} else {
							p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
						}
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + ChatColor.RED + " is not a registeret rank");
					}
				} else if (args[0].equalsIgnoreCase("set")) {
					if (Bukkit.getPlayer(args[1]) != null) {
						if (Main.permissions.get().contains("Ranks." + args[2].toLowerCase())) {
							Player to = Bukkit.getPlayer(args[1]);
							Main.playerPerms.get().set(to.getName() + ".rank", args[2].toLowerCase());
							Main.playerPerms.save();
							to.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Your rank is now "
									+ ChatColor.WHITE + ChatColor.BOLD + "\"" + Chat.getPrefix(args[2].toLowerCase())
									+ ChatColor.WHITE + ChatColor.BOLD + "\"");
						} else {
							p.sendMessage(ChatColor.DARK_RED + args[2] + ChatColor.RED + " is not a registeret rank");
						}
					} else {
						p.sendMessage(
								ChatColor.DARK_RED + args[1] + ChatColor.RED + " is either not a player or not online");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("players")) {
					if (Bukkit.getPlayer(args[1]) != null) {
						Player to = Bukkit.getPlayer(args[1]);
						p.sendMessage(ChatColor.RED + "/permissions players " + to.getName() + " [add:remove:list]");
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + ChatColor.RED
								+ " is either not online, or does not exist");
					}
				} else if (args[0].equalsIgnoreCase("ranks")) {
					if (Main.permissions.get().contains("Ranks." + args[1].toLowerCase())) {
						p.sendMessage(ChatColor.RED + "/permissions ranks " + args[1] + " [add:remove:list]");
					} else {
						p.sendMessage(ChatColor.DARK_RED + args[1] + ChatColor.RED + " is not a registeret rank");
					}
				} else if (args[0].equalsIgnoreCase("set")) {
					if (Bukkit.getPlayer(args[1]) != null) {
						p.sendMessage(ChatColor.RED + "/permission set " + args[1] + " [Rank]");
					} else {
						p.sendMessage(
								ChatColor.DARK_RED + args[1] + ChatColor.RED + " is either not a player or not online");
					}
				} else {
					p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
				}
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("players")) {
					p.sendMessage(ChatColor.RED + "/permissions players [player]");
				} else if (args[0].equalsIgnoreCase("ranks")) {
					p.sendMessage(ChatColor.RED + "/permissions ranks [rank]");
				} else if (args[0].equalsIgnoreCase("set")) {
					p.sendMessage(ChatColor.RED + "/permissions set [Player]");
				} else {
					p.sendMessage(ChatColor.RED + "Worng argument. \"/permissions\" for more help");
				}
			} else if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "/permissions [set:players:ranks]");
			} else {
				p.sendMessage(ChatColor.RED + "To many arguments. \"/permissions\" for more help");
			}
		}
		return false;
	}

}
