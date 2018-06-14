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