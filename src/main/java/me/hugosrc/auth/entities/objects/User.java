package me.hugosrc.auth.entities.objects;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class User {

    private long time;
    private boolean robot;
    private boolean logged;

    public User() {
        this.time = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(30);
        this.robot = true;
        this.logged = false;
    }

    public long getTime() {
        return time;
    }

    public boolean isRobot() {
        return robot;
    }

    public void setRobot(boolean robot) {
        this.robot = robot;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
