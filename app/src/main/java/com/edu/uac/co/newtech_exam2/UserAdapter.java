package com.edu.uac.co.newtech_exam2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> implements Filterable {

    List<String> selectedIdsList = new ArrayList<>();

    private UserListener userListener;
    private List<User> dataUsers;
    private List<User> dataUsersAll;

    public UserAdapter(List<User> dataUsers, UserListener userListener) {

        this.userListener = userListener;
        this.dataUsers = dataUsers;
        dataUsersAll = new ArrayList<>();
        dataUsersAll.addAll(dataUsers);

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

    @Override
    public Filter getFilter() {
        return myFilter;
    }

    Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<User> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(dataUsersAll);
            } else {
                for (User usr : dataUsersAll) {
                    if(usr.name.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(usr);
                    }
                }

            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {

            dataUsers.clear();
            dataUsers.addAll((Collection<? extends User>) results.values);
            notifyDataSetChanged();
        }
    };

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

    public void setFilter(ArrayList<User> newList) {
        dataUsers = new ArrayList<>();
        dataUsers.addAll(newList);
        notifyDataSetChanged();

    }
}
