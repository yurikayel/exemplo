package custom;

import com.example.exemplo.databinding.ExemploItemBinding;

import org.jetbrains.annotations.NotNull;

import custom.adapter.RecyclerViewBuilder;

import static custom.ExtFunKt.get;

public class ExemploViewBuilder extends RecyclerViewBuilder<CharSequence, ExemploItemBinding> {

    @NotNull
    @Override
    public ExemploItemBinding getBinding() {
        return bind(this, ExemploItemBinding.class);
    }

    @Override
    public void onBind(@NotNull ExemploItemBinding binding, int position) {
        binding.joaoTextview.setText(get(getCollection(), position));
    }
}
