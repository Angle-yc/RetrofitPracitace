package com.angle.retrofitpracitace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.angle.retrofitpracitace.adapters.QsbkAdapter;
import com.angle.retrofitpracitace.beans.QsbkBean;

import org.xutils.view.annotation.ViewInject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback {

    private QsbkAdapter adapter;
    private RecyclerView mRecyclerView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        loadData();
        initView();

    }

    private void initView() {
        adapter = new QsbkAdapter(this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }


    private void loadData() {
        QsbkBean.load(this);
    }

    @Override
    public void onResponse(Call call, Response response) {
        QsbkBean qsbkBean= (QsbkBean) response.body();
        adapter.setQsbkBean(qsbkBean);
        Log.d("angle","---"+qsbkBean);
    }

    @Override
    public void onFailure(Call call, Throwable t) {

    }
}
