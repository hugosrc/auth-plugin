package me.hugosrc.auth.tasks;

import me.hugosrc.auth.AuthPlugin;
import me.hugosrc.auth.entities.manager.UserManager;
import org.bukkit.Bukkit;

public class AuthTask {

    public static void start() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(AuthPlugin.getInstance(), () -> {

        }, 0, 20L);
    }

}
