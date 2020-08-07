package recycler

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.exemplo.R

class AlunoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var textView: TextView = view.findViewById(R.id.textView)
    var cardView: CardView = view.findViewById(R.id.cardView)
}


