package intent;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static custom.ExtFunKt.hideKeyBoard;

public class ClasseQualquer extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        hideKeyBoard(this);
    }
}
