package com.medal.bronze.jsnader.arkhamweakness.scenarios;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.medal.bronze.jsnader.arkhamweakness.R;
import com.medal.bronze.jsnader.arkhamweakness.support.ScenarioSelectedListener;

import java.util.List;

/**
 * This class will be responsible for managing a list of scenarios and the weaknesses associated
 * with them.
 *
 * Created by Jeremiah on 3/24/2018.
 */
public class ScenarioAdapter extends RecyclerView.Adapter<ScenarioAdapter.MyViewHolder> {
    private List<Scenario>              mScenarioList;
    private ScenarioSelectedListener    mListener;

    public ScenarioAdapter(List<Scenario> pScenarioList, ScenarioSelectedListener pListener){
        mScenarioList = pScenarioList;
        mListener = pListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup pParent, int pViewType) {
        View itemView = LayoutInflater.from(pParent.getContext()).inflate(R.layout.scenario_recycle_view_item, pParent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder pHolder, int pPosition) {
        Scenario scenario = mScenarioList.get(pPosition);
        pHolder.mScenarioType = scenario.getScenarioType();
        pHolder.mTextViewScenarioTitle.setText(scenario.getScenarioTitle());
        pHolder.mTextViewCampaignTitle.setText(scenario.getCampaignTitle());
        pHolder.mImageViewScenarioGraphic.setImageResource(scenario.getImageResource());
    }

    @Override
    public int getItemCount() {
        return mScenarioList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        private Context         mContext;
        private ScenarioType    mScenarioType;
        public TextView         mTextViewScenarioTitle;
        public TextView         mTextViewCampaignTitle;
        public ImageView        mImageViewScenarioGraphic;

        public MyViewHolder(View pView) {
            super(pView);
            mContext = pView.getContext();
            mTextViewScenarioTitle = (TextView) pView.findViewById(R.id.textViewScenarioTitle);
            mTextViewCampaignTitle = (TextView) pView.findViewById(R.id.textViewCampaignTitle);
            mImageViewScenarioGraphic = (ImageView) pView.findViewById(R.id.imageViewScenarioBackground);
            pView.setOnClickListener(this);
        }

        @Override
        public void onClick(View pView) {
            mListener.updatePage(mScenarioType);
        }
    }
}
