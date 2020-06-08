package viewpager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.exemplo.R;
import com.google.android.material.tabs.TabLayout;

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
