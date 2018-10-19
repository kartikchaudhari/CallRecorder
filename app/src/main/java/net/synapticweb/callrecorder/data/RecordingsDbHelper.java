package net.synapticweb.callrecorder.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import net.synapticweb.callrecorder.data.RecordingsContract.*;
import net.synapticweb.callrecorder.data.ListenedContract.*;


public class RecordingsDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_RECORDINGS = "CREATE TABLE " +
            Recordings.TABLE_NAME + " (" + Recordings._ID +
            " INTEGER NOT NULL PRIMARY KEY, " + Recordings.COLUMN_NAME_PHONE_NUM_ID + " INTEGER NOT NULL, "
            + Recordings.COLUMN_NAME_INCOMING + " INTEGER NOT NULL, " +
            Recordings.COLUMN_NAME_PATH + " TEXT NOT NULL, " +
            Recordings.COLUMN_NAME_START_TIMESTAMP + " INTEGER NOT NULL, " +
            Recordings.COLUMN_NAME_END_TIMESTAMP + " INTEGER NOT NULL)";

    private static final String SQL_CREATE_LISTENED = "CREATE TABLE " + Listened.TABLE_NAME + " (" + Listened._ID + " INTEGER NOT NULL PRIMARY KEY, " +
            Listened.COLUMN_NAME_NUMBER + " TEXT NOT NULL, " +
            Listened.COLUMN_NAME_CONTACT_NAME + " TEXT NOT NULL, " +
            Listened.COLUMN_NAME_PHOTO_URI + " TEXT, " +
            Listened.COLUMN_NAME_PHONE_TYPE + " INTEGER NOT NULL, " +
            Listened.COLUMN_NAME_SHOULD_RECORD + " INTEGER NOT NULL DEFAULT  1, " +
            Listened.COLUMN_NAME_PRIVATE_NUMBER + " INTEGER NOT NULL DEFAULT 0, " +
            Listened.COLUMN_NAME_UNKNOWN_NUMBER + " INTEGER NOT NULL DEFAULT 0, " +
            "CONSTRAINT no_duplicates UNIQUE(" + Listened.COLUMN_NAME_NUMBER + ") )";


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "recordings.db";

    public RecordingsDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_RECORDINGS);
        db.execSQL(SQL_CREATE_LISTENED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}