package king.cn.kingtuan.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import king.cn.kingtuan.R;
import king.cn.kingtuan.adapter.MyAdapter;


public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPage;
    private Button btnTohome;
    private int[] imgs = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3, R.mipmap.guide_4};
    private List<View> imageList = new ArrayList<>();
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mViewPage = (ViewPager) findViewById(R.id.viewpage_guide);
        btnTohome = (Button) findViewById(R.id.button_toHome);

        //初始化
        initData();

        mAdapter = new MyAdapter(imageList);
        mViewPage.setAdapter(mAdapter);
        mViewPage.setOnPageChangeListener(new MyPageListener());

        btnTohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initData() {
        //准备数据源
        for(int i = 0; i < imgs.length; i++) {
            View view = getLayoutInflater().inflate(R.layout.item_guide, null);
            ImageView guideImage = (ImageView) view.findViewById(R.id.iv);
            guideImage.setBackgroundResource(imgs[i]);
            imageList.add(view);
        }
    }


    class MyPageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position == imgs.length - 1) {
                btnTohome.setVisibility(View.VISIBLE);
            } else {
                btnTohome.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
