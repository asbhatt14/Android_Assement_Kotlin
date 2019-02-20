package com.example.ankur.android_assementtest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.row_addedlayout.view.*

class AddFriendAdapter(private val user : ArrayList<User>) : RecyclerView.Adapter<AddFriendAdapter.AddFriendHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFriendAdapter.AddFriendHolder {
        val customView = LayoutInflater.from(parent.context).inflate(R.layout.row_addedlayout,parent,false)
        return AddFriendHolder(customView)
    }

    override fun getItemCount(): Int {
        return user.size
    }

    override fun onBindViewHolder(holder: AddFriendAdapter.AddFriendHolder, position: Int) {
        var itemUser = user[position]
        holder.bindData(itemUser,user.size)

        holder.itemView.imgTick.setOnClickListener {
            deleteItem(position,holder)
        }
        holder.itemView.imgIgnore.setOnClickListener {
            deleteItem(position, holder)
        }
        holder.itemView.txtNice.setOnClickListener {
            deleteItem(position, holder)
        }

    }

    private fun deleteItem(position: Int, holder: AddFriendHolder){
        user.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
        notifyItemRangeChanged(position,user.size)
        if(user.size==0){
            // MainRecyclerAdapter.MainRecyclerHolder.
            //holder.itemView.lnrAddedView.visibility = View.GONE
        }
    }

    class  AddFriendHolder(v: View) : RecyclerView.ViewHolder(v){
        private  var view : View = v
        private var user : User? = null

        fun bindData(user: User, size: Int){
            this.user = user
            view.txtAddedUserName.text = user.name;
            var position = adapterPosition + 1;
            view.txtNoItems.text = "$position/$size"

            Picasso.get()
                    .load(user.imageUrl)
                    .error(R.drawable.ic_launcher_background)
                    .into(view.profile_image);

            if(position%2!=0){
                view.lnrView1.visibility = View.VISIBLE
                view.lnrView2.visibility = View.GONE
            }else{
                view.lnrView1.visibility = View.GONE
                view.lnrView2.visibility = View.VISIBLE
            }
        }

    }
}

