package eus.asier.personalproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Objects;

import eus.asier.personalproject.databinding.FragmentAddTeamBinding;

public class AddTeamFragment extends Fragment {

    private FragmentAddTeamBinding binding;
    private boolean listViewVisible = false; // Track the visibility state of the ListView
    private String selectedOption; // To store the selected option

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return (binding = FragmentAddTeamBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TeamsViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(TeamsViewModel.class);
        NavController navController = Navigation.findNavController(view);

        ListView listView = view.findViewById(R.id.optionsListView);
        String[] options = {"SD Eibar", "Real Sociedad", "Athletic Club", "Deportivo Alaves", "CA Osasuna"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedOption = options[position];
            }
        });

        Button showListViewButton = view.findViewById(R.id.showListViewButton);
        showListViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listViewVisible) {
                    listView.setVisibility(View.GONE); // Hide the ListView
                    listViewVisible = false;
                } else {
                    listView.setVisibility(View.VISIBLE); // Show the ListView
                    listViewVisible = true;
                }
            }
        });

        binding.newElementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = binding.description.getText().toString();
                int image;
                if (Objects.equals(selectedOption, options[0])) {
                    image = R.drawable.eibar;
                } else if (Objects.equals(selectedOption, options[1])) {
                    image = R.drawable.real_sociedad;
                } else if (Objects.equals(selectedOption, options[2])) {
                    image = R.drawable.athletic_club;
                } else if (Objects.equals(selectedOption, options[3])) {
                    image = R.drawable.deportivo_alaves;
                } else if (Objects.equals(selectedOption, options[4])) {
                    image = R.drawable.ca_osasuna;
                } else {
                    Toast.makeText(requireContext(), "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }
                elementosViewModel.insert(new Element(image, selectedOption, description));
                navController.popBackStack();
            }
        });

    }
}
