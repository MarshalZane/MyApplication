package com.bzu.gxs.chectnetwork;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    private CheckNetWork mCheckNetWork =new CheckNetWork();
    private Button btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_check:
                checkNet();
        }
    }

    /**
     * 判断是否联网
     */
    private void checkNet() {
        if(!mCheckNetWork.isNetworkAvailable(getApplication())){
            mCheckNetWork.showNetDialog(MainActivity.this);
        }else {
            Toast.makeText(MainActivity.this,"有网络，哈哈",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 初始化
     */
    private void init() {
        btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(this);
    }
}