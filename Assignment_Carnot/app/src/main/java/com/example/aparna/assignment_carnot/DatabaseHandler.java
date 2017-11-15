package com.example.aparna.assignment_carnot;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Aparna on 15-11-2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "URLS";
    private static final String TABLE_1 = "url1";
    private static final String TABLE_NAME2= "url2",TABLE3="url3",TABLE4="url4";
    private static final String POST_ID = "postId",ALBUM_ID="albumId",USER_ID="userId";
    private static final String ID = "id";
    private static final String NAME = "name", TITLE="title";
    private static final String EMAIL= "email",URL="url";
    private static final String BODY = "body",THUMBNAIL_URL="thumbnailurl",COMPLETED="completed";


    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
       // SQLiteDatabase db=this.getWritableDatabase();
       // onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PERSON_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_1 + "("
                + POST_ID + " INTEGER," + ID + " INTEGER," + NAME + " TEXT," + EMAIL + " TEXT,"
                + BODY + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE);
        String CREATE_PERSON_TABLE2="CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                + ALBUM_ID + " INTEGER," + ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," + URL + " TEXT,"
                + THUMBNAIL_URL + " TEXT" + ")";
        db.execSQL(CREATE_PERSON_TABLE2);
        String CREATE_PERSON_TABLE3="CREATE TABLE IF NOT EXISTS "+ TABLE3 + "("
                + USER_ID + " INTEGER," + ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," + COMPLETED+ " TEXT"
                + ")";
        db.execSQL(CREATE_PERSON_TABLE3);
        String CREATE_PERSON_TABLE4="CREATE TABLE IF NOT EXISTS "+ TABLE4 + "("
                + USER_ID + " INTEGER," + ID + " INTEGER PRIMARY KEY," + TITLE + " TEXT," + BODY+ " TEXT"
                + ")";
        db.execSQL(CREATE_PERSON_TABLE4);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
       // onCreate(db);
    }

    public void save(int pid, int id1, String name1, String email1, String body1){
       SQLiteDatabase db=this.getWritableDatabase();
        //onUpgrade(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        onCreate(db);

        db.execSQL("INSERT INTO " + TABLE_1 + " (postId,id,name,email,body) VALUES "
                + "('" + pid+ "', '"
                + id1+ "', '" + name1+ "','" + email1+ "','" + body1+"');");
        db.close();
    }
    public void save2(int aId, int id1, String title1, String url1, String URLThumbnail)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //onUpgrade(db);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);

        db.execSQL("INSERT INTO " + TABLE_NAME2 + " (albumId,id,title,url,thumbnailurl) VALUES "
                + "('" + aId+ "', '"
                + id1+ "', '" + title1+ "','" + url1+ "','" + URLThumbnail+"');");
        db.close();
    }
    public void save3(int uId, int id1, String title1, String completed1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //onUpgrade(db);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
        onCreate(db);

        db.execSQL("INSERT INTO url3" + " (userId,id,title,completed) VALUES "
                + "('" + uId+ "', '"
                + id1+ "', '" + title1+ "','" +completed1+"');");
        db.close();
    }
    public void save4(int uId, int id1, String title1, String body1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //onUpgrade(db);
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE4);
        onCreate(db);

        db.execSQL("INSERT INTO url4" + " (userId,id,title,body) VALUES "
                + "('" + uId+ "', '"
                + id1+ "', '" + title1+ "','" +body1+"');");
        db.close();
    }
    public String findOne(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_1, new String[]{NAME},
                ID+"=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        return cursor.getString(2);
    }
    }
