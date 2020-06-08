package revisao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exemplo.R;

public class ActRevisaoFrags extends AppCompatActivity {

    TextView benVindo;
    Button vaParaFragmentos, vaParaComunicaFrags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main_revisao);
        Bundle extras = getIntent().getExtras();
        String nome = extras != null ? extras.getString("nome") : null;

        benVindo = findViewById(R.id.benvindo_nome);
        String textoFormatado = "Bem vindo " + nome + "! Clique abaixo para ver Fragmentos:";
        benVindo.setText(textoFormatado);

        vaParaFragmentos = findViewById(R.id.benvindo_button);
        vaParaComunicaFrags = findViewById(R.id.benvindo_button_comunica_frags);

        vaParaFragmentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ActFragmentsRevisao.class));
            }
        });

        vaParaComunicaFrags.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(v.getContext(), ActComunicaFragsRevisao.class));
            }
        });

    }
}
