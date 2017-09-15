package king.cn.kingtuan.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import king.cn.kingtuan.R;
import king.cn.kingtuan.fragment.AroundFragment;
import king.cn.kingtuan.fragment.HomeFragment;
import king.cn.kingtuan.fragment.MineFragment;
import king.cn.kingtuan.fragment.MoreFragment;

public class HomeActivity extends FragmentActivity {

    private FragmentTabHost tabHost;
    private Class[] fragments = new Class[]{HomeFragment.class, AroundFragment.class, MineFragment.class, MoreFragment.class};
    private int[] tabImgs = new int[]{R.drawable.ic_home_tab_index_selector, R.drawable.ic_home_tab_near_selector,
                                        R.drawable.ic_home_tab_my_selector, R.drawable.ic_home_tab_more_selector};
    private int[] tabTexts = new int[]{R.string.home, R.string.around, R.string.mine, R.string.more};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        tabHost.setup(HomeActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);//android.R.id.tabcontent写死

        for (int i = 0; i < fragments.length; i++) {
            //映射单个tab_item
            View inflate = getLayoutInflater().inflate(R.layout.item_tabhost, null);
            ImageView tabImg = (ImageView) inflate.findViewById(R.id.item_iv);
            TextView tabText = (TextView) inflate.findViewById(R.id.item_tv);

            tabImg.setImageResource(tabImgs[i]);
            tabText.setText(tabTexts[i]);

            tabHost.addTab(tabHost.newTabSpec("" + i).setIndicator(inflate), fragments[i], null);
        }
    }
}
