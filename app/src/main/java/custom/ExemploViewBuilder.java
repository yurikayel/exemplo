package custom;

import com.example.exemplo.databinding.ExemploItemBinding;

import org.jetbrains.annotations.NotNull;

import custom.adapter.ItemViewBuilder;

import static custom.ExtFunKt.get;
import static custom.ExtFunKt.viewBind;

public class ExemploViewBuilder extends ItemViewBuilder<CharSequence, ExemploItemBinding> {

    @NotNull
    @Override
    public ExemploItemBinding getBinding() {
        return viewBind(context, ExtFunKt.getKlass(ExemploItemBinding.class));
    }

    @Override
    public void onBind(@NotNull ExemploItemBinding binding, int position) {
        binding.joaoTextview.setText(get(getCollection(), position));
    }
}
