package components;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.exemplo.R;

public class ComponentsActivity extends AppCompatActivity {

    EditText nome, email;

    ConstraintLayout layout;

    FloatingActionButton fabio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_components);

        nome = findViewById(R.id.et_nome);
        email = findViewById(R.id.et_email);
        layout = findViewById(R.id.constraint_layout);
        fabio = findViewById(R.id.fabio);

        fabio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nome.getText().toString().isEmpty() || email.getText().toString().isEmpty()){
                    Snackbar.make(layout, "Favor preencher ambos campos", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(layout, "Adicionado com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
