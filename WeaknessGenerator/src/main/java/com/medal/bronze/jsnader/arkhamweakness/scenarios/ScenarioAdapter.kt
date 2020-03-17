package com.medal.bronze.jsnader.arkhamweakness.scenarios

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.medal.bronze.jsnader.arkhamweakness.R
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioAdapter.MyViewHolder
import com.medal.bronze.jsnader.arkhamweakness.support.ScenarioSelectedListener

/**
 * This class will be responsible for managing a list of scenarios and the weaknesses associated
 * with them.
 *
 * Created by Jeremiah on 3/24/2018.
 */
class ScenarioAdapter(private val mScenarioList: MutableList<Scenario?>?, private val mListener: ScenarioSelectedListener?) : RecyclerView.Adapter<MyViewHolder?>() {
    override fun onCreateViewHolder(pParent: ViewGroup?, pViewType: Int): MyViewHolder? {
        val itemView = LayoutInflater.from(pParent?.getContext()).inflate(R.layout.scenario_recycle_view_item, pParent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(pHolder: MyViewHolder?, pPosition: Int) {
        val scenario = mScenarioList?.get(pPosition)
        pHolder?.mScenarioType = scenario?.getScenarioType()
        pHolder?.mTextViewScenarioTitle?.setText(scenario?.getScenarioTitle())
        pHolder?.mTextViewCampaignTitle?.setText(scenario?.getCampaignTitle())
        scenario?.getImageResource()?.let { pHolder?.mImageViewScenarioGraphic?.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return mScenarioList?.size!!
    }

    inner class MyViewHolder(pView: View?) : RecyclerView.ViewHolder(pView), View.OnClickListener {
        var mContext: Context?
        var mScenarioType: ScenarioType? = null
        var mTextViewScenarioTitle: TextView?
        var mTextViewCampaignTitle: TextView?
        var mImageViewScenarioGraphic: ImageView?
        override fun onClick(pView: View?) {
            mListener?.updatePage(mScenarioType)
        }

        init {
            mContext = pView?.getContext()
            mTextViewScenarioTitle = pView?.findViewById<View?>(R.id.textViewScenarioTitle) as TextView
            mTextViewCampaignTitle = pView.findViewById<View?>(R.id.textViewCampaignTitle) as TextView
            mImageViewScenarioGraphic = pView.findViewById<View?>(R.id.imageViewScenarioBackground) as ImageView
            pView.setOnClickListener(this)
        }
    }

}