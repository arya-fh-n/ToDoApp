package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.todoapp.R
import org.junit.Before
import org.junit.Test

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
class TaskActivityTest {
    @Before
    fun setup() {
        ActivityScenario.launch(TaskActivity::class.java)
    }

    @Test
    fun assertFabAddTask() {
        onView(withId(R.id.fab)).check(matches(isDisplayed()))
        onView(withId(R.id.fab)).perform(click())

        onView(withId(R.id.add_ed_title)).check(matches(isDisplayed()))
        onView(withId(R.id.add_ed_description)).check(matches(isDisplayed()))
        onView(withId(R.id.add_tv_due_date)).check(matches(isDisplayed()))
        onView(withId(R.id.action_save)).check(matches(isDisplayed()))
    }
}