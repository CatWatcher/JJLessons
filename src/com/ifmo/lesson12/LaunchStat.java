package com.ifmo.lesson12;

import java.io.Serializable;
import java.util.Date;

public class LaunchStat implements Serializable {
    private int lcount;
    private Date lastLounch;

    private String lastUser;

    public boolean isFirstLaunch () {
        return lcount == 0 && lastLounch == null;
    }

    @Override
    public String toString() {
        return "LaunchStat{" +
                "lcount=" + lcount +
                ", lastLounch=" + lastLounch +
                ", lastUser='" + lastUser + '\'' +
                '}';
    }

    public void update () {
        lcount++;
        lastLounch = new Date();
        lastUser = System.getProperty("user.name");
    }

}
