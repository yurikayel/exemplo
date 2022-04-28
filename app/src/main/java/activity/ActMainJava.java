package activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.example.exemplo.R;

import static android.widget.Toast.makeText;

public class ActMainJava extends Activity {

    EditText nome, email, endereco, profissao;

    Button enviar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.edit_nome);
        email = findViewById(R.id.edit_email);
        endereco = findViewById(R.id.edit_endereco);
        profissao = findViewById(R.id.edit_profissao);
        enviar = findViewById(R.id.button_enviar);
        enviar.setOnClickListener(view -> {
            if (todosTemTexto(nome, email, endereco, profissao)) {
                makeText(view.getContext(), "OK!", Toast.LENGTH_LONG).show();
            } else {
                makeText(view.getContext(), "Favor preencher todos os campos!", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    private boolean todosTemTexto(EditText... editTexts) {
        for (EditText et : editTexts) {
            if (et.getText().toString().isEmpty()) return false;
        }
        return true;
    }
}
