package com.medal.bronze.jsnader.arkhamweakness

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.medal.bronze.jsnader.arkhamweakness.scenarios.Scenario
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioAdapter
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioBuilder
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType
import com.medal.bronze.jsnader.arkhamweakness.support.ScenarioSelectedListener
import java.util.*

class SelectionPage : AppCompatActivity(), ScenarioSelectedListener {
    private val mScenarioList: MutableList<Scenario?>? = ArrayList()
    private var mAdapter: ScenarioAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_screen)
        val recyclerView = findViewById<View?>(R.id.recyclerView) as RecyclerView
        mAdapter = ScenarioAdapter(mScenarioList, this)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
        prepareScenarioList()
    }

    private fun prepareScenarioList() {
        mScenarioList?.clear()
        ScenarioBuilder().buildScenarioList()?.let { mScenarioList?.addAll(it) }
        mAdapter?.notifyDataSetChanged()
    }

    override fun updatePage(pScenarioType: ScenarioType?) {
        val intent = Intent(this@SelectionPage, ResultPage::class.java)
        intent.putExtra(getString(R.string.scenario_type), pScenarioType)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }
}