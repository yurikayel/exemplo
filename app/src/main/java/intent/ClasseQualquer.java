package intent;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import static custom.ExtFunKt.hideKeyBoard;

public class ClasseQualquer extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        hideKeyBoard(this);
    }
}
