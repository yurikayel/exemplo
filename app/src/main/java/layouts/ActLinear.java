package layouts;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.exemplo.R;

public class ActLinear extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_linear);
    }
}
