package com.xhf.lemon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.xhf.lemon.frag.Fragment1;
import com.xhf.lemon.frag.Fragment2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.text1)
    TextView text1;
    @BindView(R.id.text2)
    TextView text2;
    private String token = "W5JlcOCcw4kXTNyaRyVR3wEA4y/m78gvjSX8jGuecVceaMGDiJGThw9ib4kd6ZRN5xAX8V7nfzaoFdGAidhlAw==";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //test
        text1.setTextColor(Color.GREEN);
        text2.setTextColor(Color.BLACK);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Fragment1()).commit();
        /**
         * IMKit SDK调用第二步
         *
         * 建立与服务器的连接
         *
         */
        initConnect(token);

}

    private void initConnect(String token) {
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                //Connect Token 失效的状态处理，需要重新获取 Token
            }
            @Override
            public void onSuccess(String userId) {
                Log.e("MainActivity", "——onSuccess—-" + userId);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.e("MainActivity", "——onError—-" + errorCode);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * 启动单聊
         * context - 应用上下文。
         * targetUserId - 要与之聊天的用户 Id。
         * title - 聊天的标题，如果传入空值，则默认显示与之聊天的用户名称。
         */

        return super.onOptionsItemSelected(item);
}

    @OnClick({R.id.text1, R.id.text2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text1:
                text1.setTextColor(Color.GREEN);
                text2.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Fragment1()).commit();

                break;
            case R.id.text2:
                text2.setTextColor(Color.GREEN);
                text1.setTextColor(Color.BLACK);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1,new Fragment2()).commit();
                break;
        }
    }
}
