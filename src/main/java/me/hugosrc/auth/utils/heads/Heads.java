package me.hugosrc.auth.utils.heads;

import org.bukkit.inventory.ItemStack;

public enum Heads {

    GREEN("MjJkMTQ1YzkzZTVlYWM0OGE2NjFjNmYyN2ZkYWZmNTkyMmNmNDMzZGQ2MjdiZjIzZWVjMzc4Yjk5NTYxOTcifX19","green"),
    GRAY("ZjViMDk1ODQ1NTljMmY3NjQ2YTU5Y2UwM2I2Mzk0YTBhZWUwYTQzODZmZTdmNWQyYTkyMTFlYWY2MzQ2YiJ9fX0=", "gray");

    private ItemStack item;
    private String idTag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    private Heads(String texture, String id) {
        item = CustomSkull.createSkull(prefix + texture);
        idTag = id;
    }

    public ItemStack getItemStack() {
        return item;
    }

    public String getName() {
        return idTag;
    }

}
