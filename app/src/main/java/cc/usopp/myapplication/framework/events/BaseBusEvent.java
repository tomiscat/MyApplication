package cc.usopp.myapplication.framework.events;

import android.util.Log;

import com.squareup.otto.Bus;

/**
 * Bus基类
 * Created by xp on 2015/11/28.
 */
public class BaseBusEvent {
    public static Bus bus;

    public void post() {

        Log.i("<MainBus>", this.getClass().toString());
        bus.post(this);
    }
}
