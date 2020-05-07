package com.edu.uac.co.newtech_exam2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<String> selectedIdsList = new ArrayList<>();

    private List<User> dataUsers;
    private UserListener userListener;

    public UserAdapter(List<User> dataUsers, UserListener userListener) {
        this.dataUsers = dataUsers;
        this.userListener = userListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_data, parent, false);
        return  new UserViewHolder((view));
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CheckBox selectionCB;
        public TextView txtVIds;
        public TextView txtVNames;
        public TextView txtVStratums;
        public TextView txtVWage;
        public TextView txtVEduLvl;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            init(itemView);

            selectionCB.setOnClickListener(this);

        }

        public void init(View view){
            selectionCB = view.findViewById(R.id.selectCheckBox);
            txtVIds = view.findViewById(R.id.idTextV);
            txtVNames = view.findViewById(R.id.nameTxtV);
            txtVStratums =  view.findViewById(R.id.stratumTxtV);
            txtVWage =  view.findViewById(R.id.wageTxtV);
            txtVEduLvl =  view.findViewById(R.id.eduLvlTxtV);
        }

        @Override
        public void onClick(View v) {
            userListener.itemClicked(dataUsers.get(getLayoutPosition()));
        }
    }

    @Override
    public int getItemCount() {
        return dataUsers.size();
    }

    public void deleteUser(User user) {
        this.dataUsers.remove(user);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = dataUsers.get(position);

        holder.txtVIds.setText(user.id);
        holder.txtVNames.setText(user.name);
        holder.txtVStratums.setText(user.stratum);
        holder.txtVWage.setText(user.wage);
        holder.txtVEduLvl.setText(user.educationLevel);

    }
}
