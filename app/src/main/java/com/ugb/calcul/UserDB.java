package com.ugb.calcul;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class UserDB extends SQLiteOpenHelper {
    private static final String DB_NAME = "users.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";

    public UserDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aquí puedes manejar la actualización de la base de datos si es necesario
    }

    public boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String insertQuery = "INSERT INTO " + TABLE_NAME + " (" +
                COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ") VALUES ('" +
                username + "', '" + password + "')";
        try {
            db.execSQL(insertQuery);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            db.close();
        }
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                COLUMN_USERNAME + " = '" + username + "' AND " +
                COLUMN_PASSWORD + " = '" + password + "'";
        Cursor cursor = db.rawQuery(query, null);
        boolean result = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return result;
    }
}
