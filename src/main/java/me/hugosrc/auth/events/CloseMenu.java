package me.hugosrc.auth.events;

import me.hugosrc.auth.AuthPlugin;
import me.hugosrc.auth.entities.manager.UserManager;
import me.hugosrc.auth.menus.CaptchaMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CloseMenu implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();

        Bukkit.getScheduler().scheduleSyncDelayedTask(AuthPlugin.getInstance(), () -> {
            if (UserManager.getUser(player) == null) return;
            if (!UserManager.getUser(player).isRobot()) return;

            new CaptchaMenu().open(player);
        }, 10L);
    }

}
