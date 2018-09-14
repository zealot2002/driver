package com.zzy.common.utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * @author zzy
 * @date 2018/9/5
 */

public class ActivityUtils {
    public static void startActivity(final Context context,@NonNull Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context,cls);
        context.startActivity(intent);
    }
}
