package binding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.exemplo.R;
import com.example.exemplo.databinding.ActRafinhaBinding;

public class ActRafinha extends AppCompatActivity {

    ActRafinhaBinding rafinhaBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rafinhaBinding = ActRafinhaBinding.inflate(getLayoutInflater());
        setContentView(rafinhaBinding.getRoot());

        rafinhaBinding.rafinhaText.setText(R.string.vacilaum);
    }
}
