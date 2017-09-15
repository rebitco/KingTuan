package king.cn.kingtuan.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import king.cn.kingtuan.R;
import king.cn.kingtuan.adapter.MyAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View rootView;
    private View headView;
    private ViewPager vpBanner;
    private MyAdapter mAdapter;
    private List<View> bannerViews = new ArrayList<>();
    private int[] imgs = new int[]{R.mipmap.a01, R.mipmap.a02, R.mipmap.a01};

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_home, container, false);

        initData();
        initBannerView();

        return rootView;
    }

    private void initData() {
        //初始化banner数据
        for (int i = 0; i < imgs.length; i++) {
            View view = View.inflate(getActivity(), R.layout.item_banner, null);
            ImageView itemPager = (ImageView) view.findViewById(R.id.item_image);
            itemPager.setImageResource(imgs[i]);
            bannerViews.add(view);
        }
    }

    private void initBannerView() {
        //头部view
        headView = LayoutInflater.from(getActivity()).inflate(R.layout.home_headview, (ViewGroup) rootView,true);

        //banner
        vpBanner = (ViewPager) headView.findViewById(R.id.vp_banner);
        mAdapter = new MyAdapter(bannerViews);
        vpBanner.setAdapter(mAdapter);
    }

}
