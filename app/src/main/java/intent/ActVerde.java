package intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exemplo.R;

public class ActVerde extends AppCompatActivity {

    String textoRecebido;

    TextView campoDeTexto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_verde);
        if (getIntent().getExtras() != null) {
            textoRecebido = getIntent().getExtras().getString("chave");
            campoDeTexto = findViewById(R.id.textView2);
            campoDeTexto.setText(textoRecebido);
        }
    }
}
