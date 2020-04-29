package navdrawer;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.exemplo.R;

public class ActNavDrawer extends AppCompatActivity {

    AppBarConfiguration barConfig;

    // Toolbar == ActionBar == AppBar
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        achaViews();
        configNav();
    }

    void achaViews() {
        setContentView(R.layout.activity_main_nav);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    void configNav() {
        //  Configura toolbar com drawerlayout
        barConfig = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawerLayout)
                .build();

        //  Encontra fragmento onde ocorrerá navegação e cria o navController
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        //  Conecta toolbar, que já está conectada com drawerLayout, ao navController
        NavigationUI.setupActionBarWithNavController(this, navController, barConfig);

        //  Conecta navigationView ao navController
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Infla o menu; isso adiciona items à ActionBar se ela estiver presente.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, barConfig)
                || super.onSupportNavigateUp();
    }
}
