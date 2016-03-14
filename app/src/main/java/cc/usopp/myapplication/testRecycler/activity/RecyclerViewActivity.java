package cc.usopp.myapplication.testRecycler.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cc.usopp.myapplication.R;
import cc.usopp.myapplication.framework.action.BaseActivity;

/**
 * Created by xp on 2016/3/14.
 */
public class RecyclerViewActivity extends BaseActivity{

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    private List<String> mDatas;
    //    private HomeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerdatalist);

//        //设置布局管理器
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        //设置adapter
//        recyclerView.setAdapter(mAdapter = new HomeAdapter());
        ////设置Item增加、移除动画
        //        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ////添加分割线
        //        recyclerView.addItemDecoration(new DividerItemDecoration(
        //                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));


        initData();
    }

    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }

    @OnClick(R.id.recycler)
    void actionBack(){
        //数据是使用Intent返回
        Intent intent = new Intent();
        //把返回数据存入Intent
        intent.putExtra("result", "My name is xp");
        //设置返回数据RecyclerViewActivity
        this.setResult(RESULT_OK, intent);
        //关闭Activity
        this.finish();
    }
}
