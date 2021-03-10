package com.medal.bronze.jsnader.arkhamweakness.scenarios

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test

internal class ScenarioBuilderTest {

    @Test
    fun checkThatTheScenariosAreBuiltAndTheAppropriateNumber() {
        var builder = ScenarioBuilder()
        var list = builder.buildScenarioList()
        assertNotNull(list)
        assertEquals(ScenarioType.values().size, list.size)
    }

    @Test
    fun checkEachScenarioTypeHasBeenBuilt() {
        var builder = ScenarioBuilder()
        for (scenario in ScenarioType.values()) {
            assertNotNull(builder.getScenario(scenario))
        }
    }
}