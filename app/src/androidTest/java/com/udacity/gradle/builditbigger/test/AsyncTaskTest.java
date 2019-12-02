package com.udacity.gradle.builditbigger.test;


import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.MyApiAsyncTask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public final ActivityTestRule<MainActivity> mMainActivityTestRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTaskJokeResult() throws Exception {

        // Get Main Activity AsyncTask
        MyApiAsyncTask testTask = new MyApiAsyncTask(mMainActivityTestRule.getActivity());

        // Execute AsyncTask and get result
        testTask.execute();
        String joke = testTask.get();

        // Verify if AsyncTask result is empty
        assertNotNull(joke);
        assertFalse(joke.isEmpty());
    }

}
