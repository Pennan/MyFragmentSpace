package com.np.daggerdemo.entity;

import android.util.Log;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/21 17:33
 */
public class People {
    private int id;
    private String name;

    public boolean equals(People people) {
        Log.i("Level1", "getId = " + people.getId() + ",id = " + id);
        return people.getId() == id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public People(int id, String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
