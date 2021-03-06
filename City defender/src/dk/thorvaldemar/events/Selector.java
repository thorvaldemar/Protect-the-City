package dk.thorvaldemar.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Selector implements Listener {
	
	static HashMap<Player, ArrayList<Slime>> canBePlaced = new HashMap<Player, ArrayList<Slime>>();
	static HashMap<Player, ArrayList<MagmaCube>> cantBePlaced = new HashMap<Player, ArrayList<MagmaCube>>();
	static HashMap<Player, Boolean> selector = new HashMap<Player, Boolean>();

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		Block block = p.getTargetBlock((Set<Material>) null, 100);

		// p.sendMessage((block.getX() - (block.getX() % 9)) + ", " + (block.getZ() -
		// (block.getZ() % 9)));

		// if (!selector.containsKey(p) || !selector.get(p)) {
		// summonGlowers(p, block);
		// selector.put(p, true);
		// }

		if (!hasEntity(block)) {
			if (selector.containsKey(p)) {
				if (selector.get(p)) {
					update(p, block);
				}
			}
		}
	}

	public static boolean contains(Player p) {
		if (selector.containsKey(p) && selector.get(p))
			return true;
		return false;
	}

	public static boolean addPlayer(Player p) {
		if (!contains(p)) {
			Block block = p.getTargetBlock((Set<Material>) null, 100);
			summonGlowers(p, block);
			selector.put(p, true);
			return true;
		}
		return false;
	}

	public static boolean removePlayer(Player p) {
		if (contains(p)) {
			removeAllShulkers(p);
			selector.put(p, false);
			return true;
		}
		return false;
	}

	void update(Player p, Block block) {
		int x = (block.getX() - (block.getX() % 9));
		int z = (block.getZ() - (block.getZ() % 9));

		int ix = x;
		int iz = z;

		if (isFree(new Location(block.getWorld(), x, 56, iz).getBlock())) {
			for (int i = 0; i < canBePlaced.get(p).size(); i++) {
				canBePlaced.get(p).get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 0, 0), true);
				cantBePlaced.get(p).get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 10),
						true);
			}
		} else {
			for (int i = 0; i < canBePlaced.get(p).size(); i++) {
				canBePlaced.get(p).get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 10),
						true);
				cantBePlaced.get(p).get(i).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 0, 0), true);
			}
		}

		for (int i = 0; i < canBePlaced.get(p).size(); i++) {
			canBePlaced.get(p).get(i).teleport(new Location(block.getWorld(), (ix + 0.5), 56 + 0.1, (iz + 0.5)));
			cantBePlaced.get(p).get(i).teleport(new Location(block.getWorld(), (ix + 0.5), 56 + 0.1, (iz + 0.5)));
			if (ix < (x + 8)) {
				ix++;
			} else if (iz < (z + 9)) {
				iz++;
				ix = x;
			} else {
				iz = z;
			}
		}
	}

	static void summonGlowers(Player p, Block block) {
		ArrayList<Slime> sul = new ArrayList<Slime>();
		ArrayList<MagmaCube> aSul = new ArrayList<MagmaCube>();

		for (int x = 999; x < (999 + 9); x++) {
			for (int z = 999; z < (999 + 9); z++) {
				Slime glower = p.getWorld().spawn(new Location(p.getWorld(), x, 56, z), Slime.class);
				// p.sendMessage(x + ", " + z);
				// glower.setGlowing(true);
				glower.setSilent(true);
				glower.setAI(false);
				glower.setInvulnerable(true);
				glower.setSize(2);
				// glower.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
				// 999999, 10), true);
				sul.add(glower);
			}
		}
		for (int x = 999; x < (999 + 9); x++) {
			for (int z = 999; z < (999 + 9); z++) {
				MagmaCube glower = p.getWorld().spawn(new Location(p.getWorld(), x, 56, z), MagmaCube.class);
				// p.sendMessage(x + ", " + z);
				glower.setSilent(true);
				glower.setAI(false);
				glower.setInvulnerable(true);
				glower.setSize(2);
				// glower.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,
				// 999999, 10), true);
				aSul.add(glower);
			}
		}
		canBePlaced.put(p, sul);
		cantBePlaced.put(p, aSul);
	}

	public static void removeAllShulkers(Player p) {
		for (int t = 0; t <= 6; t++) {
			if (canBePlaced.containsKey(p)) {
				for (int i = 0; i < canBePlaced.get(p).size(); i++) {
					canBePlaced.get(p).get(i).remove();
				}
				for (int i = 0; i < cantBePlaced.get(p).size(); i++) {
					cantBePlaced.get(p).get(i).remove();
				}
			}
		}
		canBePlaced.remove(p);
		cantBePlaced.remove(p);
	}

	boolean isFree(Block block) {
		for (int x = block.getX(); x < (block.getX() + 9); x++) {
			for (int y = 57; y < (57 + 29); y++) {
				for (int z = block.getZ(); z < (block.getZ() + 9); z++) {
					if (!new Location(block.getWorld(), x, y, z).getBlock().getType().equals(Material.AIR)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	boolean hasEntity(Block block) {
		for (Entity entity : block.getWorld().getEntities()) {
			if (entity.getLocation().equals(
					new Location(block.getWorld(), block.getX() + 0.5, block.getY(), block.getZ() + 0.5, 180, 0))) {
				return true;
			}
		}
		return false;
	}

}
