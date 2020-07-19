package com.bci.passdatausingvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Objects;

public class PlayersListFragment extends Fragment {
    private PlayerViewModel viewModel;
    private ListView lv;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this.requireActivity()).get(PlayerViewModel.class);

        lv.setAdapter(new ArrayAdapter<String>(this.requireActivity(),
                android.R.layout.simple_list_item_1, viewModel.getPlayerList()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View itemView, int pos, long id) {
                TextView tv = (TextView) itemView;
                Toast.makeText(PlayersListFragment.this.getContext(), tv.getText().toString(), Toast.LENGTH_SHORT).show();
                viewModel.selectPlayer(tv.getText().toString());
                NavHostFragment.findNavController(PlayersListFragment.this)
                        .navigate(R.id.action_PlayersListFragment_to_PlayerDetailsFragment);
            }
        });
    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first,
                container, false);
        lv = (ListView)view.findViewById(R.id.players_lv);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}