package custom

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder

abstract class RecyclerAdapter<Type : ViewHolder>(collection: Collection<*>) : Adapter<Type>() {

    var collection: Collection<*> = collection
        set(value) {
            field = value
            notifyDataSetChanged()
        }
}