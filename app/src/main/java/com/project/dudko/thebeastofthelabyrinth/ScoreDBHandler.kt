package com.project.dudko.thebeastofthelabyrinth

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.content.ContentValues

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

    fun addScore(score: Score){
        val values = ContentValues()
        values.put(COLUMN_LEVEL, score.level)
        values.put(COLUMN_COINS, score.coins)
        values.put(COLUMN_TURNS, score.turns)

        val db = this.writableDatabase

        db.insert(TABLE_MAPS, null, values)
        db.close()
    }

    fun findLevel(levelname: String): Score? {
        val query =
                "SELECT * FROM $TABLE_MAPS WHERE $COLUMN_LEVEL =  \"$levelname\""

        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        var score: Score? = null

        if (cursor.moveToFirst()) {
            cursor.moveToFirst()

            val id = Integer.parseInt(cursor.getString(0))
            val level = cursor.getString(1)
            val coins = Integer.parseInt(cursor.getString(2))
            val turns = Integer.parseInt(cursor.getString(3))
            score = Score(id, level, coins, turns)
            cursor.close()
        }

        db.close()
        return score
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