package custom.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class RecyclerViewHolder(val builder: RecyclerViewBuilder) :
    RecyclerView.ViewHolder(builder.build())

abstract class RecyclerViewBuilder {
    abstract val layout: Int
    lateinit var viewGroup: ViewGroup
    lateinit var view: View
    lateinit var collection: Collection<Any>

    fun init(viewGroup: ViewGroup, collection: Collection<Any>): RecyclerViewBuilder {
        this.viewGroup = viewGroup
        this.collection = collection
        return this
    }

    fun build(): View {
        view = LayoutInflater.from(viewGroup.context).inflate(layout, null, false)
        return view
    }

    fun bind(position: Int) = view.onBind(position)

    abstract fun View.onBind(position: Int)
}