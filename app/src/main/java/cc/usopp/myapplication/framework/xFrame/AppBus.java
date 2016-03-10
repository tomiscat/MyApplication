package cc.usopp.myapplication.framework.xFrame;

import com.squareup.otto.Bus;

/**
 * Bus类 单例
 * Created by xp on 2016/3/10.
 */
public class AppBus extends Bus {
    private static AppBus bus;

    public static AppBus getInstance() {
        if (bus == null) {
            bus = new AppBus();
        }
        return bus;
    }
}
