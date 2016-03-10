package cc.usopp.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.robobinding.ViewBinder;
import org.robobinding.binder.BinderFactory;
import org.robobinding.binder.BinderFactoryBuilder;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cc.usopp.myapplication.framework.action.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String TAG = "ActivityDemo";

    @Bind(R.id.edit)
    EditText edit;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    @OnClick(R.id.fab)
    void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private ViewBinder createViewBinder() {
        BinderFactory reusableBinderFactory = new BinderFactoryBuilder().build();
        return reusableBinderFactory.createViewBinder(this);
    }

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
}
