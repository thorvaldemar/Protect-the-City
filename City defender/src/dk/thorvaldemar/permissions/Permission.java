package dk.thorvaldemar.permissions;

import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import dk.thorvaldemar.Main;

public class Permission {

	public static boolean hasPermission(CommandSender p, String permission) {
		List<String> playerPerms = Main.playerPerms.get().getStringList(p.getName() + ".personalPermissions");
		List<String> rankPerms = Main.permissions.get()
				.getStringList("Ranks." + Main.playerPerms.get().getString(p.getName() + ".rank") + ".permissions");

		//

		String multiple = permission.substring(0, permission.lastIndexOf('.')) + ".*";

		if (p instanceof ConsoleCommandSender || playerPerms.contains(permission) || playerPerms.contains(multiple)
				|| rankPerms.contains(permission) || rankPerms.contains(multiple) || p.isOp()) {
			return true;
		}
		return false;
	}

}
