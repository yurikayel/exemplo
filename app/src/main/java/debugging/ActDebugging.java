package debugging;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.exemplo.R;

import base.ActBase;

public class ActDebugging extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_debugging);

        findViewById(R.id.button_rafinha_exception).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                throw new NullPointerException();
            }
        });
    }
}
