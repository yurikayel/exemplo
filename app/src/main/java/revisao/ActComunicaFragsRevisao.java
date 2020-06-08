package revisao;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.exemplo.R;

public class ActComunicaFragsRevisao extends AppCompatActivity implements ActivityContract {

    FragmentManager manager = getSupportFragmentManager();

    FragVerde fragVerde = FragVerde.newInstance(new Bundle());
    FragVermelho fragVermelho = FragVermelho.newInstance(new Bundle());
    FragAzul fragAzul = FragAzul.newInstance(new Bundle());

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        achaViews();
        carregaFragmento(FragVermelho.newInstance(new Bundle()));
    }

    public void achaViews() {
        setContentView(R.layout.act_comunica_frags_revisao);
    }

    @Override
    public void setTextVermelho(String textVermelho) {
        carregaFragmento(fragVermelho);
        fragVermelho.setTextVermelho(textVermelho);
    }

    @Override
    public void setTextVerde(String textVerde) {
        carregaFragmento(fragVerde);
        fragVerde.setTextVerde(textVerde);
    }

    @Override
    public void setTextAzul(String textAzul) {
        carregaFragmento(fragAzul);
        fragAzul.setTextAzul(textAzul);
    }

    private void carregaFragmento(final Fragment fragment) {
        manager
                .beginTransaction()
                .replace(R.id.comunica_frags_framelayout, fragment)
                .commitNow();

        if (fragment instanceof FragVermelho) {
            fragVermelho = (FragVermelho) fragment;
        }

        if (fragment instanceof FragVerde) {
            fragVerde = (FragVerde) fragment;
        }

        if (fragment instanceof FragAzul) {
            fragAzul = (FragAzul) fragment;
        }
    }

    private boolean voltaSeTiver(String fragName) {
        return manager.popBackStackImmediate(fragName, 0);
    }

//    private void carregaFragVermelho() {
//        FragmentTransaction transaction = rafinha.beginTransaction();
//        transaction.replace(R.id.comunica_frags_framelayout, new FragVermelho());
//        transaction.commit();
//    }

}
