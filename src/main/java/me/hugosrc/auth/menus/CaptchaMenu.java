package me.hugosrc.auth.menus;

import me.hugosrc.auth.entities.manager.UserManager;
import me.hugosrc.auth.utils.builder.ItemBuilder;
import me.hugosrc.auth.utils.heads.CustomSkull;
import me.hugosrc.auth.utils.inventory.Menu;
import org.bukkit.entity.Player;

import java.util.Random;

public class CaptchaMenu extends Menu {

    public CaptchaMenu() {
        super("Clique no bloca verde", 3);
    }

    @Override
    public void open(Player player) {

        for (int slot = 0; slot < this.getInventory().getSize(); slot++) {
            setItem(
                    slot,
                    new ItemBuilder(CustomSkull.getHead("gray"))
                            .setDisplayName("§7Clique no bloco verde")
                            .build(),
                    event -> {
                        UserManager.kickPlayer(player, "Você errou o captcha, tente novamente!");
                    });
        }

        setItem(
                new Random().nextInt(this.getInventory().getSize()),
                new ItemBuilder(CustomSkull.getHead("green"))
                        .setDisplayName("§aClique aqui!")
                        .build(),
                event -> {
                    UserManager.setPlayerIsNotRobot(player);
                });

        super.open(player);
    }
}
