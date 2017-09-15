package king.cn.kingtuan.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import king.cn.kingtuan.R;

public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getPreferences(MODE_PRIVATE);
                boolean isFirst = preferences.getBoolean(getResources().getString(R.string.isFirst), true);

                if(isFirst) {
                    startToActivity(GuideActivity.class);
                    preferences.edit().putBoolean(getResources().getString(R.string.isFirst), false).commit();//第二次进入就取反
                } else {
                    startToActivity(HomeActivity.class);
                }
            }
        }, 2000);
    }

    //封装跳转页面
    private void startToActivity(Class cls) {
        Intent intent_ = new Intent(SplashActivity.this, cls);
        startActivity(intent_);
        finish();
    }
}
