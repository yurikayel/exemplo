package recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.exemplo.R;

public class AdapterChamada extends RecyclerView.Adapter<ChamadaViewHolder> {

    private String[] chamada;

    public AdapterChamada(String[] chamada){
        this.chamada = chamada;
    }

    @NonNull
    @Override
    public ChamadaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.texto_pequeno, viewGroup, false);
        return new ChamadaViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamadaViewHolder chamadaViewHolder, int position) {
        chamadaViewHolder.textViewTexticulo.setText(chamada[position]);
    }

    @Override
    public int getItemCount() {
        return chamada.length;
    }
}
