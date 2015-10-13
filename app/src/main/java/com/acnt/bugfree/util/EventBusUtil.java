package com.acnt.bugfree.util;

import de.greenrobot.event.EventBus;
import trikita.log.Log;

/**
 * 使用EventBus的工具类,提供注册和反注册的工具
 * Created by NiuKY on 10/12.
 */
public class EventBusUtil {

    //这个值会在log的组件中被使用,该组件会使用抛出一个异常,然后获得当前类的的成员
    @SuppressWarnings("unused")
    private static final String TAG = "EventBusUtil";

    public static void register(Object src) {

        EventBus bus = EventBus.getDefault();
        if (!bus.isRegistered(src)) {
            bus.register(src);
        }
    }

    public static void unRegister(Object src) {
        EventBus bus = EventBus.getDefault();
        if (bus.isRegistered(src)) {
            bus.unregister(src);
            Log.d("unRegister:", src);
        }
    }

    public static void postEvent(Object event) {
        EventBus bus = EventBus.getDefault();
        bus.postSticky(event);
    }
}
