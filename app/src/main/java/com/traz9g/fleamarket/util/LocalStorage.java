package com.traz9g.fleamarket.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.traz9g.fleamarket.App;
import com.traz9g.fleamarket.defines.LocalStorageDefines;

public class LocalStorage {
    private static Context mContext = App.appContext;

    public static void setString(String key, String value) {
        SharedPreferences storage = mContext.getSharedPreferences(LocalStorageDefines.STORAGE_NAME,
                Context.MODE_PRIVATE);
        storage.edit().putString(key, value).apply();
    }

    public static String getString(String key, String defaultValue) {
        SharedPreferences storage = mContext.getSharedPreferences(LocalStorageDefines.STORAGE_NAME,
                Context.MODE_PRIVATE);
        return storage.getString(key, defaultValue);
    }

    public static void setInt(String key, int value) {
        SharedPreferences storage = mContext.getSharedPreferences(LocalStorageDefines.STORAGE_NAME,
                Context.MODE_PRIVATE);
        storage.edit().putInt(key, value).apply();
    }

    public static int getInt(String key, int defaultValue) {
        SharedPreferences storage = mContext.getSharedPreferences(LocalStorageDefines.STORAGE_NAME,
                Context.MODE_PRIVATE);
        return storage.getInt(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value) {
        SharedPreferences storage = mContext.getSharedPreferences(LocalStorageDefines.STORAGE_NAME,
                Context.MODE_PRIVATE);
        storage.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        SharedPreferences storage = mContext.getSharedPreferences(LocalStorageDefines.STORAGE_NAME,
                Context.MODE_PRIVATE);
        return storage.getBoolean(key, defaultValue);
    }
}