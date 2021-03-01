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
package com.medal.bronze.jsnader.arkhamweakness

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medal.bronze.jsnader.arkhamweakness.scenarios.Scenario
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioAdapter
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioBuilder
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType
import com.medal.bronze.jsnader.arkhamweakness.support.ScenarioSelectedListener
import java.util.*

class SelectionPage : AppCompatActivity(), ScenarioSelectedListener {
    private val mScenarioList: MutableList<Scenario> = ArrayList()
    private lateinit var mAdapter: ScenarioAdapter

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
        mScenarioList.clear()
        ScenarioBuilder().buildScenarioList().let { mScenarioList.addAll(it) }
        mAdapter.notifyDataSetChanged()
    }

    override fun updatePage(pScenarioType: ScenarioType) {
        val intent = Intent(this@SelectionPage, ResultPage::class.java)
        intent.putExtra(getString(R.string.scenario_type), pScenarioType)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }
}