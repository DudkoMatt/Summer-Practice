package com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues
import android.database.Cursor

class ScoreDBHandler(context: Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = ("CREATE TABLE " +
                TABLE_MAPS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_LEVEL + " TEXT," +
                COLUMN_COINS + " TEXT," +
                COLUMN_TURNS + " TEXT)")
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_MAPS")
        onCreate(db)
    }

    fun getAllDataForCurrentLevel(level: String): Cursor{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_MAPS WHERE $COLUMN_LEVEL = $level", null)
    }

    fun addScore(score: Score){
        val values = ContentValues()
        values.put(COLUMN_LEVEL, score.level)
        values.put(COLUMN_COINS, score.coins)
        values.put(COLUMN_TURNS, score.turns)

        val db = this.writableDatabase

        db.insert(TABLE_MAPS, null, values)
        db.close()
    }

    fun findLevel(levelname: String): MutableList<MutableList<String>> {
        val query =
                "SELECT * FROM $TABLE_MAPS WHERE $COLUMN_LEVEL =  \"$levelname\" ORDER BY $COLUMN_COINS DESC, $COLUMN_TURNS ASC LIMIT 5"

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var result = MutableList(2){i -> MutableList(0){""}}


        if (cursor != null && cursor.count > 0) {
            while (cursor.moveToNext()) {
                var buffer = Array(2){""}
                //val id = Integer.parseInt(cursor.getString(0))
                //buffer[0] = cursor.getString(1)  //level
                buffer[0]= cursor.getString(2)   //coins
                buffer[1]= cursor.getString(3)   //turns
                result[0].add(buffer[0])
				result[1].add(buffer[1])
            }

        }

        cursor.close()
        db.close()
        return result
    }

    fun deleteScores(){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_MAPS")
        db.close()
    }
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "maps.db"
        val TABLE_MAPS = "maps"

        val COLUMN_ID = "_id"
        val COLUMN_LEVEL = "level"
        val COLUMN_COINS = "coins"
        val COLUMN_TURNS = "turns"
    }
}