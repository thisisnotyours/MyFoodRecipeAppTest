package com.suek.practice05;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    Fragment[] fragments= new Fragment[5];
    String[] tabTexts= new String[]{"추천","분류","최신","랭킹","이슈"};


    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments[0]= new Tab1Fragment();
        fragments[1]= new Tab2Fragment();
        fragments[2]= new Tab3Fragment();
        fragments[3]= new Tab4Fragment();
        fragments[4]= new Tab5Fragment();


    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    //탭레이아웃과 연동한다면 탭버튼의 보여질 글씨를 리턴해주는 메소드가 따로있음..
    //단점은 아이콘을 만들수없어서 메인자바로 가서 만들기..
    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return tabTexts[position];
    }

}
