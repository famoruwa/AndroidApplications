package com.example.felixamoruwa.statisticsapplication.db;

/**
 * Created by felixamoruwa on 7/15/15.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.felixamoruwa.statisticsapplication.model.Student;

import java.util.ArrayList;


public class DBUtils {
    private static final String DATABASE_NAME = "StudentScores";
    private SQLiteDatabase database;
    private DatabaseOpenHelper databaseOpenHelper;

    public DBUtils(Context context) {
        databaseOpenHelper = new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
    }


    public void open() throws SQLException {
        database = databaseOpenHelper.getWritableDatabase();
    }


    public void close() {
        if (database != null)
            database.close();
    }


    public void insertQuery(Student stu) {
        ContentValues newQuery = new ContentValues();
        newQuery.put("studentId", stu.getStudentId());
        newQuery.put("q1", stu.getQ1());
        newQuery.put("q2", stu.getQ2());
        newQuery.put("q3", stu.getQ3());
        newQuery.put("q4", stu.getQ4());
        newQuery.put("q5", stu.getQ5());

        open();
        database.insert("scores", null, newQuery);
        close();
    }

    public Student selectAStudentQuery(int studentId) {
        open();
        Cursor result =  database.query("scores", null, "studentId=" + studentId, null, null,
                null, null, null);
        Student stu;
        try {
            result.moveToFirst();

            stu = new Student(
                    result.getInt(0),
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getInt(5)
            );
        } finally {
            result.close();
            close();
        }

        return stu;
    }

    public ArrayList<Student> selectAllStudentsQuery() {
        open();
        Cursor result =  database.query("scores", null, null, null, null,
                null, null, null);
        ArrayList<Student> students = new ArrayList<Student>();
        Student stu;
        try {
            if(result!=null) {
                while(result.moveToNext()) {
                    stu = new Student(
                            result.getInt(0),
                            result.getInt(1),
                            result.getInt(2),
                            result.getInt(3),
                            result.getInt(4),
                            result.getInt(5)
                    );
                    students.add(stu);
                }
            }
        } finally {
            result.close();
            close();
        }

        return students;
    }

    private class DatabaseOpenHelper extends SQLiteOpenHelper {

        public DatabaseOpenHelper(Context context, String name,
                                  SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            String createQuery = "CREATE TABLE scores "
                    + "(studentId integer primary key,"
                    + "q1 integer,"
                    + "q2 double,"
                    + "q3 integer,"
                    + "q4 double,"
                    + "q5 integer);";

            db.execSQL(createQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }
}
