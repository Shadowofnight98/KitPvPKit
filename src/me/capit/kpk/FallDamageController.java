package me.capit.kpk;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class FallDamageController implements Listener {
	KPKPlugin plugin;
	public FallDamageController(KPKPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e){
		if (e.getCause()==DamageCause.FALL && e.getEntity() instanceof Player){
			Player player = (Player) e.getEntity();
			if (plugin.getConfig().getBoolean("fall_damage.enabled",false)){ e.setCancelled(true); return; }
			if (plugin.getConfig().getBoolean("fall_damage.enabled_in_combat",true)){
				e.setCancelled(!plugin.isInCombat(player.getUniqueId()));
			}
		}
	}
	
}
