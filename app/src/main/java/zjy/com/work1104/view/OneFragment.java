package zjy.com.work1104.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zjy.com.work1104.adapter.MyFragmentAdapter;
import zjy.com.work1104.R;

/**
 * Created by ZhangJiaYu on 2017/11/4.
 */
public class OneFragment extends android.support.v4.app.Fragment {
    TabLayout mytab;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_one,null);
        mytab = (TabLayout)view. findViewById(R.id.mytab);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        initData();
        return view;
    }

    private void initData() {
        List<Fragment> list = new ArrayList<>();
        for (int i = 0; i <7 ;i++){
            list.add(new HomeFragment());
        }
        MyFragmentAdapter adapter = new MyFragmentAdapter(getFragmentManager());
        adapter.setList(list);
        viewPager.setAdapter(adapter);
        for (int i = 0 ;i<7;i++){
            mytab.addTab(mytab.newTab());
        }
        mytab.setupWithViewPager(viewPager);
        mytab.getTabAt(0).setText("沪深");
        mytab.getTabAt(1).setText("板块");
        mytab.getTabAt(2).setText("指数");
        mytab.getTabAt(3).setText("港股");
        mytab.getTabAt(4).setText("新三板");
        mytab.getTabAt(5).setText("商品");
        mytab.getTabAt(6).setText("其他");
        mytab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
