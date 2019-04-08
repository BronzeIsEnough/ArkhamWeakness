package com.medal.bronze.jsnader.arkhamweakness;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.medal.bronze.jsnader.arkhamweakness.scenarios.Scenario;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioAdapter;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioBuilder;
import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType;
import com.medal.bronze.jsnader.arkhamweakness.support.ScenarioSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class SelectionPage extends AppCompatActivity implements ScenarioSelectedListener{
    private List<Scenario>  mScenarioList = new ArrayList<>();
    private ScenarioAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new ScenarioAdapter(mScenarioList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareScenarioList();
    }

    private void prepareScenarioList() {
        mScenarioList.clear();
        mScenarioList.addAll(new ScenarioBuilder().buildScenarioList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void updatePage(ScenarioType pScenarioType) {
        Intent intent = new Intent(SelectionPage.this, ResultPage.class);
        intent.putExtra(getString(R.string.scenario_type), pScenarioType);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}
