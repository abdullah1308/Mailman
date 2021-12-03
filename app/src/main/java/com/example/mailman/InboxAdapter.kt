package com.example.mailman

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mailman.databinding.MailListItemBinding
import model.Message

class InboxAdapter(
    private val emailList: List<Message>
): RecyclerView.Adapter<InboxAdapter.InboxItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: InboxItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class InboxItemViewHolder(
        val inboxItemBinding: MailListItemBinding
    ) : RecyclerView.ViewHolder(inboxItemBinding.root)
}