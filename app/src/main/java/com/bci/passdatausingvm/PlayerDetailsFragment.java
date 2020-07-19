package com.bci.passdatausingvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;

public class PlayerDetailsFragment extends Fragment {
    private PlayerViewModel viewModel;

    private TextView name;
    private TextView age;
    private TextView country;
    private TextView titles;
    private TextView rank;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this.requireActivity()).get(PlayerViewModel.class);

        viewModel.getSelectedPlayer().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String item) {
                displayDetails(viewModel.getPlayerDetails(item));
            }
        });
    }

    public void displayDetails(Player player){
        if(player!=null){
            name.setText(player.getName());
            age.setText(""+player.getAge());
            country.setText(player.getCountry());
            titles.setText(""+player.getTitles());
            rank.setText(""+player.getRank());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second,
                container, false);

        name = view.findViewById(R.id.name);
        age = view.findViewById(R.id.age);
        country = view.findViewById(R.id.country);
        titles = view.findViewById(R.id.titles);
        rank = view.findViewById(R.id.rank);

        return view;
    }
}