package com.hyp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Fragment_Main extends AppCompatActivity {
    public Fragment mF1;//4个碎片
    public Fragment mF2;
    public Fragment mF3;
    public Fragment mF4;
    @BindView(R.id.frame_tab)
    FrameLayout mFrameTab;
    @BindView(R.id.iv_house_tab)
    ImageView mIvHouseTab;
    @BindView(R.id.tv_house_tab)
    TextView mTvHouseTab;
    @BindView(R.id.ll_house_tab)
    LinearLayout mLlHouseTab;
    @BindView(R.id.iv_hydropower_tab)
    ImageView mIvHydropowerTab;
    @BindView(R.id.tv_hydropower_tab)
    TextView mTvHydropowerTab;
    @BindView(R.id.ll_hydropower_tab)
    LinearLayout mLlHydropowerTab;
    @BindView(R.id.iv_rent_tab)
    ImageView mIvRentTab;
    @BindView(R.id.tv_rent_tab)
    TextView mTvRentTab;
    @BindView(R.id.ll_rent_tab)
    LinearLayout mLlRentTab;
    @BindView(R.id.iv_me_tab)
    ImageView mIvMeTab;
    @BindView(R.id.tv_me_tab)
    TextView mTvMeTab;
    @BindView(R.id.ll_me_tab)
    LinearLayout mLlMeTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_main);
        ButterKnife.bind(this);
        initView();

    }



    private void initView() {
        setSelect(0);
    }

    @OnClick({R.id.ll_house_tab, R.id.ll_hydropower_tab, R.id.ll_rent_tab, R.id.ll_me_tab})
  public void onClick(View v){
        switch (v.getId()) {
            case R.id.ll_house_tab:
                resetImg();
                setSelect(0);
//                Toast.makeText(this, "ll_house_tab", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_hydropower_tab:
                resetImg();
                setSelect(1);
                break;
            case R.id.ll_rent_tab:
                resetImg();
                setSelect(2);
                break;
            case R.id.ll_me_tab:
                resetImg();
                setSelect(3);
                break;
        }
    }

    private void resetImg() {

        // TODO 切换图片成暗色 调用setImageResource 更换图片按钮控件中的图片
        mIvHouseTab.setImageResource(R.mipmap.tab_house_dark);
        mIvHydropowerTab.setImageResource(R.mipmap.tab_caobiao_dark);
        mIvRentTab.setImageResource(R.mipmap.tab_shouzu_dark);
        mIvMeTab.setImageResource(R.mipmap.tab_me_dark);


        mTvHouseTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.no_activation));
        mTvHydropowerTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.no_activation));
        mTvRentTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.no_activation));
        mTvMeTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.no_activation));
    }

    public void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();// 拿到FRAGMENT 管理器
        FragmentTransaction transaction = fm.beginTransaction();// 开启一个事务
//        transaction.replace(R.id.frame_tab, mF1);
        hideFragment(transaction);// 所有的先隐藏 然后显示出我们想要的那个就行了 传入事务参数


        switch (i) {


            case 0:// 判断mtab01是否为空，是则初始化，否则直接显示出来
                mIvHouseTab.setImageResource(R.mipmap.tab_house);
                mTvHouseTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.activation));
                if (mF1 == null) {
                    mF1 = new F1();
                    transaction.add(R.id.frame_tab, mF1);
                }//两个参数，一个控件 ，一个布局，将控件传到布局里
                else {
                    transaction.show(mF1);

                }
                break;

            case 1:

                mIvHydropowerTab.setImageResource(R.mipmap.tab_caobiao);
                mTvHydropowerTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.activation));

                if (mF2 == null) {
                    mF2 = new F2();
                    transaction.add(R.id.frame_tab, mF2);
                } else {
                    transaction.show(mF2);
                }


                break;
            case 2:
                mIvRentTab.setImageResource(R.mipmap.tab_shouzu);
                mTvRentTab.setTextColor(ContextCompat.getColor(Fragment_Main.this,R.color.activation));

                if (mF3 == null) {
                    mF3 = new F3();
                    transaction.add(R.id.frame_tab, mF3);
                } else {
                    transaction.show(mF3);
                }



                break;
            case 3:

                mIvMeTab.setImageResource(R.mipmap.tab_me);
                mTvMeTab.setTextColor(ContextCompat.getColor(Fragment_Main.this, R.color.activation));
                if (mF4 == null) {
                    mF4 = new F4();
                    transaction.add(R.id.frame_tab, mF4);
                } else {
                    transaction.show(mF4);
                }


                break;

        }

        transaction.commit();

    }
    // TODO 隐藏事物 方法
    public void hideFragment(FragmentTransaction transaction) {

        if (mF1 != null) { // 如果不为空，首先把他们4个都隐藏，然后 在setSelect中设置显示
            transaction.hide(mF1);
        }
        if (mF2 != null) {
            transaction.hide(mF2);
        }
        if (mF3 != null) {
            transaction.hide(mF3);
        }
        if (mF4 != null) {
            transaction.hide(mF4);
        }

    }
}


