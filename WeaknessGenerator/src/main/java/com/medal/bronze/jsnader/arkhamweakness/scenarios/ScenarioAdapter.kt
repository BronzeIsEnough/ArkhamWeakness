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
package com.medal.bronze.jsnader.arkhamweakness.scenarios

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.medal.bronze.jsnader.arkhamweakness.R
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioAdapter.MyViewHolder
import com.medal.bronze.jsnader.arkhamweakness.support.ScenarioSelectedListener

/**
 * This class will be responsible for managing a list of scenarios and the weaknesses associated
 * with them.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class ScenarioAdapter(
        private val mScenarioList: MutableList<Scenario>,
        private val mListener: ScenarioSelectedListener) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(pParent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
                LayoutInflater.from(pParent.context).inflate(
                        R.layout.scenario_recycle_view_item, pParent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(pHolder: MyViewHolder, pPosition: Int) {
        val scenario = mScenarioList.get(pPosition)
        pHolder.mScenarioType = scenario.getScenarioType()
        pHolder.mTextViewScenarioTitle.text = scenario.getScenarioTitle()
        pHolder.mTextViewCampaignTitle.text = scenario.getCampaignTitle()
        scenario.getImageResource().let {
            pHolder.mImageViewScenarioGraphic?.setImageResource(it)
        }
    }

    override fun getItemCount(): Int {
        return mScenarioList.size
    }

    inner class MyViewHolder(pView: View) : RecyclerView.ViewHolder(pView), View.OnClickListener {
        var mContext: Context
        var mScenarioType: ScenarioType? = null
        var mTextViewScenarioTitle: TextView
        var mTextViewCampaignTitle: TextView
        var mImageViewScenarioGraphic: ImageView?
        override fun onClick(pView: View?) {
            mScenarioType?.let { mListener.updatePage(it) }
        }

        init {
            pView.context.also { mContext = it }
            mTextViewScenarioTitle =
                    pView.findViewById<View>(R.id.textViewScenarioTitle) as TextView
            mTextViewCampaignTitle =
                    pView.findViewById<View>(R.id.textViewCampaignTitle) as TextView
            mImageViewScenarioGraphic =
                    pView.findViewById<View>(R.id.imageViewScenarioBackground) as ImageView

            pView.setOnClickListener(this)
        }
    }
}