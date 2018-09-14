package com.zzy.driver.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

/**
 * @author zzy
 * @date 2018/9/13
 */
public class MyJobCreator implements JobCreator {

    @Override
    @Nullable
    public Job create(@NonNull String tag) {
        switch (tag) {
            case DemoSyncJob.TAG:
                return new DemoSyncJob();
            case TestJob.TAG:
                return new TestJob();
            default:
                return null;
        }
    }
}