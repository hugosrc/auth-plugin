package me.hugosrc.auth.entities.manager;

import me.hugosrc.auth.entities.objects.User;
import org.bukkit.entity.Player;

import java.util.*;

public class UserManager {

    private static Map<UUID, User> USERS = new HashMap<>();

    public static void addUser(Player player) {
        USERS.put(player.getUniqueId(), new User());
    }

    public static User getUser(Player player) {
        return USERS.get(player.getUniqueId());
    }

    public static void setPlayerIsNotRobot(Player player) {
        player.closeInventory();
        USERS.get(player.getUniqueId()).setRobot(false);
    }

    public static void setPlayerLogged(Player player) {
        USERS.get(player.getUniqueId()).setLogged(true);
    }

    public static void kickPlayer(Player player, String message) {
        player.kickPlayer(message);
    }

    public static boolean containsUser(Player player) {
        return USERS.containsKey(player.getUniqueId());
    }

    public static void removeUser(Player player) {
        USERS.remove(player.getUniqueId());
    }

    public static Map<UUID, User> getUSERS() {
        return USERS;
    }
}
