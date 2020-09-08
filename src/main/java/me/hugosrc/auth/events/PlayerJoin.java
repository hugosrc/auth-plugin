package me.hugosrc.auth.events;

import me.hugosrc.auth.AuthPlugin;
import me.hugosrc.auth.entities.manager.UserManager;
import me.hugosrc.auth.menus.CaptchaMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (UserManager.containsUser(player)) return;

        Bukkit.getScheduler().scheduleSyncDelayedTask(AuthPlugin.getInstance(), () -> {
            new CaptchaMenu().open(player);
        }, 20L);

        UserManager.addUser(player);
    }

}
