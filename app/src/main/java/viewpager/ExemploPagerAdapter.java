package viewpager;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ExemploPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> nomes;

    public ExemploPagerAdapter(
            List<Fragment> fragments,
            List<String> nomes,
            FragmentManager fragmentManager) {
        super(fragmentManager);
        this.fragmentList = fragments;
        this.nomes = nomes;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return nomes.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
