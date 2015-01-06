package me.capit.kpk;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CombatController implements Listener {
	KPKPlugin plugin;
	public CombatController(KPKPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e){
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			plugin.enterCombat(((Player) e.getEntity()).getUniqueId());
			plugin.enterCombat(((Player) e.getDamager()).getUniqueId());
		}
	}
	
}
