package intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
    }
}
