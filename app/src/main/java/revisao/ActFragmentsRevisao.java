package revisao;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.exemplo.R;

public class ActFragmentsRevisao extends AppCompatActivity {

    Button mostraFusca, mostraCamaro;

    FragmentManager manager = getSupportFragmentManager();

    View.OnClickListener clickFusca = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            carregaFragmentoFusca();
        }
    };

    View.OnClickListener clickCamaro = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            carregaFragmentoCamaro();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        achaViews();
        carregaFragmentoFusca();
    }

    private void achaViews() {
        setContentView(R.layout.act_fragments_revisao);
        mostraFusca = findViewById(R.id.troca_frags_fusca);
        mostraCamaro = findViewById(R.id.troca_frags_camaro);

        mostraFusca.setOnClickListener(clickFusca);
        mostraCamaro.setOnClickListener(clickCamaro);
    }

    private void carregaFragmentoFusca() {
        manager.beginTransaction().replace(R.id.troca_frags_framelayout, new FragFusca()).commit();
    }

    public void carregaFragmentoCamaro(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.troca_frags_framelayout, new FragCamaroMeiaBoca());
        transaction.commit();
    }
}
