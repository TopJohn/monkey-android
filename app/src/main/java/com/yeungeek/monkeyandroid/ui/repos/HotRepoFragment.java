package com.yeungeek.monkeyandroid.ui.repos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yeungeek.monkeyandroid.R;
import com.yeungeek.monkeyandroid.data.model.Language;
import com.yeungeek.monkeyandroid.ui.base.view.BaseToolbarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeungeek on 2016/3/29.
 */
public class HotRepoFragment extends BaseToolbarFragment {
    private LanguagesPagerAdapter mPagerAdapter;

    @Override
    protected void initToolbar() {
        getActionBar().setTitle(R.string.menu_title_repo);
    }

    @Override
    protected void initViews() {
        super.initViews();

        mPagerAdapter = new LanguagesPagerAdapter(getChildFragmentManager());
        getViewPager().setAdapter(mPagerAdapter);
        getTabLayout().setupWithViewPager(getViewPager());
    }

    public class LanguagesPagerAdapter extends FragmentPagerAdapter {
        List<Language> languagesArray = new ArrayList<>();

        public LanguagesPagerAdapter(FragmentManager fm) {
            super(fm);
            languagesArray.addAll(dataManager.getLanguageHelper().getLanguage());
        }

        @Override
        public Fragment getItem(int position) {
            return RepoListFragment.newInstance(getContext(), languagesArray.get(position));
        }

        @Override
        public int getCount() {
            return languagesArray.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return languagesArray.get(position).name;
        }
    }
}