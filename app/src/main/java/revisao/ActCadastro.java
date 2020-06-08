package revisao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.exemplo.R;

public class ActCadastro extends AppCompatActivity {

    private EditText nome, email, senha;
    private Button cadastrar;

    private View.OnClickListener onClickCadastrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (todosPreenchidos(nome, email, senha)) {
                Toast.makeText(view.getContext(), "OK!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(view.getContext(), ActRevisaoFrags.class).putExtra("nome", nome.getText().toString()));
            } else {
                Toast.makeText(view.getContext(), "Faltou preencher aí!", Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cadastro_revisao);
        nome = findViewById(R.id.cadastro_nome);
        email = findViewById(R.id.cadastro_email);
        senha = findViewById(R.id.cadastro_senha);

        cadastrar = findViewById(R.id.cadastro_cadastrar);
        cadastrar.setOnClickListener(onClickCadastrar);
    }

    private boolean todosPreenchidos(EditText... listaDeCamposDeTexto) {
        for (EditText campoDeTexto : listaDeCamposDeTexto) {
            if (campoDeTexto.getText().toString().isEmpty()) return false;
        }
        return true;
    }
}
