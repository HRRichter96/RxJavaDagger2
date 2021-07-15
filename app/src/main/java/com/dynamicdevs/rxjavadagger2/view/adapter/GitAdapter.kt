package com.dynamicdevs.rxjavadagger2.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevs.rxjavadagger2.databinding.ListItemViewBinding
import com.dynamicdevs.rxjavadagger2.model.Result
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem

class GitAdapter(private val delegate: GitDelegate) : RecyclerView.Adapter<GitAdapter.GitViewHolder>() {


    interface GitDelegate {
        fun selectCard(gitResponseItem: GitResponseItem)
    }

    inner class GitViewHolder(val binding: ListItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    var repos: List<GitResponseItem> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitViewHolder {
        val binding = ListItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GitViewHolder, position: Int) {

        with(repos[position]) {
            holder.binding.apply {
                holder.binding.languageTv.text = repos[position].language
                holder.binding.ownerNameTv.text = repos[position].owner.login
                holder.binding.repoNameTv.text = repos[position].name
                holder.binding.urlTv.text = repos[position].html_url

                holder.binding.inspectIv.setOnClickListener {
                     val gitResponseItem = repos[position]

                    delegate.selectCard(gitResponseItem)
                    Log.d("TAG_X", "Clicked on item.")

                }


            }
        }
    }

    override fun getItemCount() = repos.size
}