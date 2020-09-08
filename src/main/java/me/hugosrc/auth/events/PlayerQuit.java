package me.hugosrc.auth.events;

import me.hugosrc.auth.entities.manager.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (!UserManager.containsUser(player)) return;

        UserManager.removeUser(player);
    }

}
