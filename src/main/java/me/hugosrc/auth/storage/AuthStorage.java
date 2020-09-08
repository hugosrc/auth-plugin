package me.hugosrc.auth.storage;

import me.hugosrc.core.core.CorePlugin;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AuthStorage {

    private Connection connection;

    public AuthStorage() {
        this.connection = CorePlugin.getDatabase().getConnection();

        createTable();
    }

    private void createTable() {
        if (connection == null) return;

        PreparedStatement preparedStatement = null;

        try {
            String query = "CREATE TABLE IF NOT EXISTS `auth` (id int(10) AUTO_INCREMENT, player_uuid varchar(36) NOT NULL UNIQUE, password varchar(255), PRIMARY KEY(id));";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void insert(Player player, String password) {
        if (connection == null) return;

        PreparedStatement preparedStatement = null;

        try {
            String query = "INSERT INTO `auth` (`player_uuid`, `password`) VALUES (?, ?);";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, player.getUniqueId().toString());
            preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {

    }

    public void select() {

    }

}
