package me.hugosrc.auth;

import me.hugosrc.auth.commands.LoginCommand;
import me.hugosrc.auth.commands.RegisterCommand;
import me.hugosrc.auth.events.CloseMenu;
import me.hugosrc.auth.events.PlayerJoin;
import me.hugosrc.auth.events.PlayerQuit;
import me.hugosrc.auth.storage.AuthStorage;
import me.hugosrc.auth.utils.inventory.MenuListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuthPlugin extends JavaPlugin {

    public static AuthPlugin instance;

    @Override
    public void onEnable() {
        loadConfig();
        loadInstances();

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void loadInstances() {
        instance = this;
    }

    private void loadConfig() {
        saveDefaultConfig();
    }

    private void registerCommands() {
        getCommand("register").setExecutor(new RegisterCommand());
        getCommand("login").setExecutor(new LoginCommand());
    }

    private void registerEvents() {
        PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new MenuListener(), this);
        pluginManager.registerEvents(new PlayerJoin(), this);
        pluginManager.registerEvents(new PlayerQuit(), this);
        pluginManager.registerEvents(new CloseMenu(), this);
    }

    public static AuthPlugin getInstance() {
        return instance;
    }
}
