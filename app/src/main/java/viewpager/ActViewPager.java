package viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.exemplo.R;

import java.util.ArrayList;
import java.util.List;

import fragment.FragAzul;
import fragment.FragVerde;
import fragment.FragVermelho;

public class ActViewPager extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ExemploPagerAdapter pagerAdapter;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> nomes = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_pager);
        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        fragmentList.add(FragVermelho.newInstance(new Bundle()));
        fragmentList.add(FragVerde.newInstance(new Bundle()));
        fragmentList.add(FragAzul.newInstance(new Bundle()));

        nomes.add("Xandão");
        nomes.add("Rafão");
        nomes.add("Peter Henry II");

        pagerAdapter = new ExemploPagerAdapter(fragmentList, nomes, getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pagerAdapter);
    }
}
