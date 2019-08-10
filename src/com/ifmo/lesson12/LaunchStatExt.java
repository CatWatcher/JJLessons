package com.ifmo.lesson12;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class LaunchStatExt implements Externalizable {

    // чтобы можно было добавлять новые поля
    private static final long serialVersion = 0L;
    private static final int VERSION = 1;

    private String user;

    private int lcount;
    private Date lastLounch;


    public boolean isFirstLaunch () {
        return lcount == 0 && lastLounch == null;
    }

    @Override
    public String toString() {
        return "LaunchStatExt{" +
                "lcount=" + lcount +
                ", lastLounch=" + lastLounch +
                '}';
    }



    public void update () {
        lcount++;
        lastLounch = new Date();
        //lastUser = System.getProperty("user.name");
        user = System.getProperty("user.name");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        // тут описываем как добавлять каждое отдельное свойство
        out.writeInt(VERSION);
        out.writeInt(lcount);
        out.writeObject(lastLounch);
        // записываем дополнительное свойство в файл
        out.writeUTF(user);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        int version = in.readInt();
        if (version > VERSION) {
            throw new IOException("Version not support");
        }
        lcount = in.readInt();
        lastLounch = (Date) in.readObject();

        // описываем правила чтения новых объектов

        if (version > 0) {
            user = in.readUTF();
        }

    }
}
