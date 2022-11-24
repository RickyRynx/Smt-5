package com.if5b.contact.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if5b.contact.R;
import com.if5b.contact.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.ViewHolder> {
    private List<User> data = new ArrayList<>();
    private OnClickListener listener;

    public UserViewAdapter() {
        this.data = data;
    }

    public void setData(List<User> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewAdapter.ViewHolder holder, int position) {
        User user = data.get(position);

        holder.tvname.setText("Name : " + user.getName());
        holder.tvemail.setText("Email : " + user.getEmail());
        holder.tvphone.setText("Phone : " + user.getPhone());

        holder.ivedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onEditClicked(user);
                }
            }
        });

        holder.ivdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onDeleteClicked(user.getId());
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname,tvemail,tvphone;
        private ImageView ivedit,ivdelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tv_name);
            tvemail = itemView.findViewById(R.id.tv_email);
            tvphone = itemView.findViewById(R.id.tv_phone);
            ivedit = itemView.findViewById(R.id.iv_edit);
            ivdelete = itemView.findViewById(R.id.iv_delete);
        }
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public interface OnClickListener {
        void onEditClicked(User user);
        void onDeleteClicked(int userId);
    }
}
