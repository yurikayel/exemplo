package intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.exemplo.R;

public class ActAzul extends AppCompatActivity {

    String textoRecebido;

    TextView campoDeTexto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_azul);
        textoRecebido = getIntent().getExtras().getString("chave");
        campoDeTexto = findViewById(R.id.textView3);
        campoDeTexto.setText(textoRecebido);
    }
}
