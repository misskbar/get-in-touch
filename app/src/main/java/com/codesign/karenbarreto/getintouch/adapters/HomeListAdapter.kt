package com.codesign.karenbarreto.getintouch.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.codesign.karenbarreto.getintouch.Navigator
import com.codesign.karenbarreto.getintouch.R
import com.karenbarreto.core.helpers.inflate
import kotlinx.android.synthetic.main.home_item.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class HomeListAdapter
@Inject constructor() : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    internal var collection: List<RepositoryView> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (RepositoryView, Navigator.Extras) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.home_item))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
            viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repositoryView: RepositoryView, clickListener: (RepositoryView, Navigator.Extras) -> Unit) {
            itemView.repository_name.text= repositoryView.repositoryName
            itemView.description.text= repositoryView.repositoryDescription
            itemView.forks.text= repositoryView.repositoryForks
            itemView.stars.text= repositoryView.repositoryStars
//            itemView.moviePoster.loadFromUrl(movieView.poster)
//            itemView.setOnClickListener { clickListener(movieView, Navigator.Extras(itemView.moviePoster)) }
        }
    }
}