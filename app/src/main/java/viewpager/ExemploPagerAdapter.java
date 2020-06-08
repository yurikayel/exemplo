package viewpager;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
