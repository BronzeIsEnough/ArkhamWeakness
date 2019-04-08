package com.medal.bronze.jsnader.arkhamweakness.support;

import com.medal.bronze.jsnader.arkhamweakness.scenarios.ScenarioType;

/**
 * A callback to the calling activity for them to handle the selection that was made within the
 * adapter for the RecyclerView.
 *
 * Created by Jeremiah on 3/25/2018.
 */
public interface ScenarioSelectedListener {
    void updatePage(ScenarioType pScenarioType);
}
