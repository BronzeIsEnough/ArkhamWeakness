/**
 * Copyright 2018-2021 Jeremiah Snader
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.medal.bronze.jsnader.arkhamweakness.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.medal.bronze.jsnader.arkhamweakness.support.CardConverters

/**
 * The database has the responsibility of keeping track of what data and methods for accessing that
 * data should be represented in our database.  In this case it references the [Card] and [CardDao]
 * classes that we can retrieve information from.  It is created as a singleton and made volatile
 * and synchronized to keep us from bad behavior when accessing it.  The room database class will
 * hold versioning and we can export the schema for tracking over time if desired.
 */
@Database(entities = [Card::class], version =  1, exportSchema = false)
@TypeConverters(CardConverters::class)
abstract class CardDatabase : RoomDatabase() {
    abstract fun cardDao() : CardDao

    companion object {
        @Volatile
        private var INSTANCE : CardDatabase? = null

        fun getDatabase(context: Context) : CardDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        CardDatabase::class.java,
                        "card_database").addCallback(
                            object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    val request =
                                            OneTimeWorkRequestBuilder<CardDatabaseWorker>().build()
                                    WorkManager.getInstance(context).enqueue(request)
                                }
                            }
                        ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}