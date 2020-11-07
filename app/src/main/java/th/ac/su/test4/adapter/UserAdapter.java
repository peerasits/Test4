package th.ac.su.test4.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.test4.R;
import th.ac.su.test4.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private User[] mUsers;

    public UserAdapter(Context context, User[] users) {
        this.mContext = context;
        this.mUsers = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mUsers[position];

        holder.fullNameTextView.setText(user.firstName);
        holder.surNameTextView.setText(user.lastName);
    }

    @Override
    public int getItemCount() {
        return mUsers.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fullNameTextView;
        TextView surNameTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.fullNameTextView = itemView.findViewById(R.id.name_text);
            this.surNameTextView = itemView.findViewById(R.id.surname_text);

        }
    }
}
