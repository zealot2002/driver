package com.zzy.driver.job;

import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;
import com.zzy.commonlib.log.MyLog;

/**
 * @author zzy
 * @date 2018/9/13
 */
public class TestJob extends Job {

    public static final String TAG = "TestJob";

    @Override
    @NonNull
    protected Result onRunJob(@NonNull Params params) {
        // run your job here
        MyLog.e("TestJob TestJob");
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        new JobRequest.Builder(TestJob.TAG)
                .setExecutionWindow(3000L, 4000L)
                .build()
                .schedule();
    }
}