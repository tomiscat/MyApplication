package cc.usopp.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.usopp.myapplication.framework.action.BaseActivity;
import cc.usopp.myapplication.framework.bean.DataEvent;
import cc.usopp.myapplication.framework.xFrame.AppBus;
import cc.usopp.myapplication.testRecycler.activity.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "ActivityDemo";

    @Bind(R.id.edit)
    EditText edit;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.txtView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBinding();//各种绑定初始化

        setSupportActionBar(toolbar);

        /*
            ===robobinding绑定===
            PresentationModel presentationModel = new PresentationModel();
            ViewBinder viewBinder = createViewBinder();
            View rootView = viewBinder.inflateAndBind(R.layout.activity_main, presentationModel);
            setContentView(rootView);
        */
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("edit", edit.getText().toString());
        Log.d(TAG, "txtView onSaveInstanceState~~~");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "txtView onRestoreInstanceState~~~");
        Log.d(TAG, "edit" + savedInstanceState.get("edit"));
    }

    @OnClick(R.id.txtView)
    void onSubmit() {
        Log.d(TAG, "txtView onSubmit~~~");
        AppBus.getInstance().post(new DataEvent("test bus"));//发布DataEvent消息
    }

    @OnClick(R.id.fab)
    void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

//    private ViewBinder createViewBinder() {
//        BinderFactory reusableBinderFactory = new BinderFactoryBuilder().build();
//        return reusableBinderFactory.createViewBinder(this);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "start onStart~~~");
        Log.d(TAG, "edit.getText() : " + edit.getText());

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "start onResume~~~");
        Log.d(TAG, "edit.getText() : " + edit.getText());
//        edit.setText(edit.getText());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "start onPause~~~");
        Log.d(TAG, "edit.getText() : " + edit.getText());
    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Subscribe
    public void testEvent(DataEvent data) {
        Log.d(TAG, "testEvent: " + data.getContent());

        Intent intent = new Intent(this, RecyclerViewActivity.class);

        startActivityForResult(intent, 0);
    }

    /**
     * 为了得到传回的数据，必须在前面的Activity中（指MainActivity类）重写onActivityResult方法
     *
     * requestCode 请求码，即调用startActivityForResult()传递过去的值
     * resultCode 结果码，结果码用于标识返回数据来自哪个新Activity
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String result = data.getExtras().getString("result");//得到新Activity 关闭后返回的数据
        Log.i(TAG, result);
    }
}
