package custom;

import android.view.View;
import android.widget.TextView;

import com.example.exemplo.R;

import org.jetbrains.annotations.NotNull;

import custom.adapter.RecyclerViewBuilder;

import static custom.ActHostKt.get;

public class ExemploViewBuilder extends RecyclerViewBuilder<CharSequence> {

    @Override
    public int getLayout() {
        return R.layout.exemplo_item;
    }

    @Override
    public void onBind(@NotNull View view, int position) {
        TextView textView = view.findViewById(R.id.joao_textview);
        textView.setText(get(getCollection(), position));
    }
}
