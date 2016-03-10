package cc.usopp.myapplication.framework.bean;

import cc.usopp.myapplication.framework.events.BaseBusEvent;

/**
 * Created by xp on 2016/3/10.
 */
public class DataEvent extends BaseBusEvent {
    public String content;

    public DataEvent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
