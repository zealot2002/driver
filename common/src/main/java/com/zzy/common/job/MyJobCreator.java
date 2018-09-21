package com.zzy.common.job;

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
            case LazyJob.TAG:
                return new LazyJob();

            case LazyWorkJob.TAG:
                return new LazyWorkJob();
            default:
                return null;
        }
    }
}