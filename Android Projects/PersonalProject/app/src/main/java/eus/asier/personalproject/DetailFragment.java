package eus.asier.personalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import eus.asier.personalproject.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentDetailBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TeamsViewModel teamsViewModel = new ViewModelProvider(requireActivity()).get(TeamsViewModel.class);

        teamsViewModel.selected().observe(getViewLifecycleOwner(), new Observer<Element>() {
            @Override
            public void onChanged(Element team) {
                binding.name.setText(team.getName());
                binding.description.setText(team.getDescription());

                String imageName = team.getName().toLowerCase().replace(" ", "_");
                @SuppressLint("DiscouragedApi") int imageResourceId = getResources().getIdentifier(imageName, "drawable", requireContext().getPackageName());

                if (imageResourceId != 0) {
                    binding.imageView4.setImageResource(imageResourceId);
                }

                binding.web.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = team.getName();
                        String url;
                        switch (name) {
                            case "SD Eibar":
                                url = "https://www.sdeibar.com";
                                break;
                            case "Real Sociedad":
                                url = "https://www.realsociedad.eus";
                                break;
                            case "Athletic Club":
                                url = "https://www.athletic-club.eus";
                                break;
                            case "Deportivo Alaves":
                                url = "https://www.deportivoalaves.com";
                                break;
                            case "CA Osasuna":
                                url = "https://www.osasuna.es";
                                break;
                            default:
                                url = "https://www.example.com";
                                break;
                        }
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        startActivity(intent);
                    }
                });

                binding.loc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = team.getName();
                        String stadiumName;

                        switch (name) {
                            case "SD Eibar":
                                stadiumName = "Ipurua";
                                break;
                            case "Real Sociedad":
                                stadiumName = "Anoeta";
                                break;
                            case "Athletic Club":
                                stadiumName = "San Mames";
                                break;
                            case "Deportivo Alaves":
                                stadiumName = "Mendizorrotza";
                                break;
                            case "CA Osasuna":
                                stadiumName = "El Sadar";
                                break;
                            default:
                                stadiumName = name + " Stadium";
                                break;
                        }

                        String mapSearchUri = "geo:0,0?q=" + Uri.encode(stadiumName);
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapSearchUri));
                        startActivity(intent);
                    }
                });

            }
        });
    }
}
