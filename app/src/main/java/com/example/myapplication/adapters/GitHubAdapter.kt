package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.db.Entity

class GitHubAdapter(private val repolists: List<Entity>) :
    RecyclerView.Adapter<GitHubAdapter.GitHubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.github_card, parent, false)

        return GitHubViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repolists.size
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        holder.bind(repolists[position])
    }

    class GitHubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val owner: TextView = itemView.findViewById(R.id.txt_owner_name)
        private val repoName: TextView = itemView.findViewById(R.id.txt_repo_name)
        private val repoLink: TextView = itemView.findViewById(R.id.txt_repo_link)

        fun bind(entity: Entity) {
            owner.text = entity.userName
            repoName.text = entity.repName
            repoLink.text = entity.detailLink
        }
    }
}