package recycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.exemplo.R;

import java.util.ArrayList;
import java.util.List;

import revisao.ActRevisaoFrags;

public class AdapterChamada extends RecyclerView.Adapter<ChamadaViewHolder> {

    private List<String> chamada;

    public AdapterChamada(List<String> chamada) {
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
        final String nome = chamada.get(position);

        chamadaViewHolder.textViewTexticulo.setText(nome);
        chamadaViewHolder.textViewTexticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, ActRevisaoFrags.class).putExtra("nome", nome);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return chamada.size();
    }
}
