package dk.thorvaldemar.enums.functions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import net.minecraft.server.v1_12_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_12_R1.PacketPlayOutTitle.EnumTitleAction;

public enum Title {
	;
	
	public static void playTitle(Entity p, String str, ChatColor color, boolean isBold) {
		net.minecraft.server.v1_12_R1.PacketPlayOutTitle title = new net.minecraft.server.v1_12_R1.PacketPlayOutTitle(EnumTitleAction.TITLE,
				ChatSerializer.a("{\"text\":\"" + str + "\",\"color\":\"" + color.toString() + "\",\"bold\":\"" + isBold + "\"}"), 20, 40, 20);
		((org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer)p).getHandle().playerConnection.sendPacket(title);
	}
	
	public static void addSubtitle(Entity p, String str, ChatColor color, boolean isBold) {
		net.minecraft.server.v1_12_R1.PacketPlayOutTitle subtitle = new net.minecraft.server.v1_12_R1.PacketPlayOutTitle(EnumTitleAction.SUBTITLE,
				ChatSerializer.a("{\"text\":\"" + str + "\",\"color\":\"" + color.toString() + "\",\"bold\":\"" + isBold + "\"}"), 20, 40, 20);
		((org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer)p).getHandle().playerConnection.sendPacket(subtitle);
	}
}
