package me.capit.kpk;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class KPKPlugin extends JavaPlugin {
	private final Map<UUID,Integer> inCombat = new TreeMap<UUID,Integer>();
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		new BukkitRunnable(){
			@Override
			public void run() {
				for (UUID id : inCombat.keySet()){
					if (inCombat.get(id).intValue()>=1) inCombat.put(id, inCombat.get(id)-1);
					else inCombat.remove(id);
				}
			}
		}.runTaskTimerAsynchronously(this, 0, 20L);
	}
	
	public void enterCombat(UUID id){
		inCombat.put(id, getConfig().getInt("combat.timer",30));
	}
	
	public boolean isInCombat(UUID id){
		return inCombat.containsKey(id);
	}
System.out.println("ALL YOUR BASE ARE BELONG TO MR. SMITH");
	
}
