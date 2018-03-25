package com.example.test.myduitang.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.test.myduitang.R;
import com.example.test.myduitang.fragment.DiscoverFragment;
import com.example.test.myduitang.fragment.MoveFragment;
import com.example.test.myduitang.fragment.MsgFragment;
import com.example.test.myduitang.fragment.PopularFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.toolbar_main) Toolbar mToolbarMain;
  @BindView(R.id.tab_main) TabLayout mTabLayout;
  @BindView(R.id.view_pager) ViewPager mViewPager;

  public String[] pageTitle = {"热门", "发现", "动态", "消息"};
  public List<Fragment> fragmentList;
  public MyViewPagerAdapter pagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    addFragment();
    mToolbarMain.setTitle("我的堆糖");
    mToolbarMain.setTitleTextColor(getResources().getColor(R.color.colorAccent));
    pagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
    mViewPager.setAdapter(pagerAdapter);
    mTabLayout.setupWithViewPager(mViewPager);
  }

  private void addFragment() {
    fragmentList = new ArrayList<>();
    fragmentList.add(new PopularFragment());
    fragmentList.add(new DiscoverFragment());
    fragmentList.add(new MoveFragment());
    fragmentList.add(new MsgFragment());
  }

  public class MyViewPagerAdapter extends FragmentPagerAdapter {
    /*FragmentPagerAdapter是android-support-v4支持包里面出现的一个新的适配器，继承自PagerAdapter，
    是专门用来给支持包中出现的ViewPager进行数据适配的
    * */
    public MyViewPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override public Fragment getItem(int position) {
      return fragmentList.get(position);
    }
    @Override public CharSequence getPageTitle(int position) {
      return pageTitle[position];
    }
    @Override public int getCount() {
      return fragmentList.size();
    }
  }
}
