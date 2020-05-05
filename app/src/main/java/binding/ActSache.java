package binding;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.exemplo.databinding.ActSacheBinding;

import org.jetbrains.annotations.NotNull;

import base.ActBind;
import revisao.ActCadastro;
import revisao.ActRevisaoFrags;

public class ActSache extends ActBind<ActSacheBinding> {

    public ActSache() {
        super(ActSacheBinding.class);
    }

    @Override
    public void onBoundView(@NotNull ActSacheBinding sacheBinding) {
        binding.whiskasImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                context.startActivity(new Intent(context, ActCadastro.class));
            }
        });
        binding.whiskasText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                context.startActivity(new Intent(context, ActRevisaoFrags.class));
            }
        });
    }
}
