package dk.thorvaldemar.loops;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import dk.thorvaldemar.Main;

public final class ScoreboardLoop extends BukkitRunnable {	
	int next = 2000;
	int air = 0;

	private static Main plugin;

	public ScoreboardLoop(Main pl) {
		plugin = pl;
	}
	
	
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {

			ScoreboardManager manager = Bukkit.getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();

			Objective objective = board.registerNewObjective(p.getName(), "dummy");
			
			next = 2000;

			plugin.getClass();
			
//			addScore(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + "Stars: " + (plugin.getplayerdata().getInt(p.getName() + ".stars")), board, objective);
//			addScore(airSTR(), board, objective);
//			addScore(ChatColor.BLUE + "" + ChatColor.BOLD + "Kills: " + (plugin.getplayerdata().getInt(p.getName() + ".kills")), board, objective);
//			addScore(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Deaths: " + (plugin.getplayerdata().getInt(p.getName() + ".deaths")), board, objective);
//			addScore(airSTR(), board, objective);
//			addScore(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Money: " + (plugin.getplayerdata().getInt(p.getName() + ".money")), board, objective);
//			addScore(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Level: " + (plugin.getplayerdata().getInt(p.getName() + ".level")), board, objective);

			air = 0;

			objective.setDisplaySlot(DisplaySlot.SIDEBAR);
			objective.setDisplayName(ChatColor.valueOf("green".toUpperCase()) + "" + ChatColor.BOLD + p.getName());

			p.setScoreboard(board);
			
		}
	}
	
	void addScore(String str, Scoreboard board, Objective objective) {
		String rsl = str;

		Score scorelevel = objective.getScore(str);

		board.resetScores(rsl);

		scorelevel.setScore(next);
		next -= 1;
	}

	String airSTR() {
		String str = "";

		for (int n = 0; n <= air; n++) {
			str += ChatColor.RESET.toString();
		}
		air += 1;
		return str;
	}
}