package intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exemplo.R;

import java.util.Objects;

public class ActVermelha extends AppCompatActivity {

    String textoRecebido;

    TextView campoDeTexto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vermelha);
        if (getIntent().getExtras() != null) {
            textoRecebido = Objects.requireNonNull(getIntent().getExtras()).getString("chave");
            campoDeTexto = findViewById(R.id.textView);
            campoDeTexto.setText(textoRecebido);
        }

        ExemploLOL exemplo = new ExemploLOL();

        exemplo.patoFazQuack();

        ExemploLOLKt.noobReclamaDoLag();

        ExemploLOLKt.gatoMia("miau");
    }
}
