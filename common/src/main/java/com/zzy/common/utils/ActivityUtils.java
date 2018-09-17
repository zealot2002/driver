package com.zzy.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.zzy.common.constants.ParamConstants;

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
    public static void startActivity(final Context context,final String param,@NonNull Class<?> cls) {
        Intent intent = new Intent();
        intent.putExtra(ParamConstants.PARAM_DATA,param);
        intent.setClass(context,cls);
        context.startActivity(intent);
    }
    public static void startActivity(final Context context, final Bundle param, @NonNull Class<?> cls) {
        Intent intent = new Intent();
        intent.putExtras(param);
        intent.setClass(context,cls);
        context.startActivity(intent);
    }
}
