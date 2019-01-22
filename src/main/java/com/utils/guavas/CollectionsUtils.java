package com.utils.guavas;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.Closer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;

public class CollectionsUtils {
    public static void main(String[] args) {
        ImmutableSet set = ImmutableSet.of("1","2","3");
        //

        Connection conn = null;
        Closer closeable = Closer.create();
        try {
            closeable.register(new FileInputStream("abc"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
