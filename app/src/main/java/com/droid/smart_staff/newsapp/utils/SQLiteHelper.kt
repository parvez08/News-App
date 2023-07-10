package com.droid.smart_staff.newsapp.utils

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class SQLiteHelper(context: Context?) {

    companion object {
        const val DATABASE_NAME = "kashin.db"
        const val TABLE_NAME = "kashin_articles_table"
        const val COL_1 = "offline_article_id"
        const val COL_2 = "id"
        const val COL_3 = "image_url"
        const val COL_4 = "title"
        const val COL_5 = "description"
        const val COL_6 = "category"
        const val COL_7 = "source_link"
        const val COL_8 = "source_name"
        const val COL_9 = "created_on"
    }
}