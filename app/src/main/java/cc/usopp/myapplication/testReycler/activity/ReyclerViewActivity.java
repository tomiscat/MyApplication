package cc.usopp.myapplication.testReycler.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cc.usopp.myapplication.R;
import cc.usopp.myapplication.framework.action.BaseActivity;

/**
 * Created by YiNing on 2016/3/14.
 */
public class ReyclerViewActivity extends BaseActivity{

    @Bind(R.id.recycler)
    RecyclerView recyclerView;

    private List<String> mDatas;
    //    private HomeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reyclerdatalist);

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
}
