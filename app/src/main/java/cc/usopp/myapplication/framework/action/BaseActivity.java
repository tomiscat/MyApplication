package cc.usopp.myapplication.framework.action;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import cc.usopp.myapplication.framework.xFrame.AppBus;

/**
 * Activity基类
 * Created by xp on 2016/3/10.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);//绑定军刀嘎嘎嘎
    }

    @Override
    protected void onStart() {
        super.onStart();
        AppBus.getInstance().register(this);//注册Bus
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppBus.getInstance().unregister(this);//销毁Bus
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
