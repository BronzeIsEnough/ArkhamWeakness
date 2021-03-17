package com.medal.bronze.jsnader.arkhamweakness.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.medal.bronze.jsnader.arkhamweakness.support.CampaignAffinity
import com.medal.bronze.jsnader.arkhamweakness.support.CardTrait
import com.medal.bronze.jsnader.arkhamweakness.support.MythosCardType
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import java.io.IOException

@RunWith(AndroidJUnit4::class)
internal class CardDatabaseTestImpl {
    private lateinit var mCardDao: CardDao
    private lateinit var db: CardDatabase
    private lateinit var mCard : Card

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, CardDatabase::class.java).build()
        mCardDao = db.cardDao()
        mCard = Card(
            10,
            "Amnesia",
            true,
            1,
            "https://www.arkhamdb.com",
            CampaignAffinity.DUNWICH_LEGACY,
            MythosCardType.TREACHERY,
            arrayListOf(CardTrait.MADNESS),
            arrayListOf(),
            "Flavor Text",
            "Jeremiah Snader",
            0,
            0,
            0,
            0,
            0)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeCardAndReadInList() {
        var list : LiveData<List<Card>>
        list = mCardDao.readAllData()
        assertTrue(list.value == null)
        mCardDao.addCard(mCard)
        list = mCardDao.readAllData()
        assertEquals(mCard.name, list.value?.get(0)?.name)
    }
}