package eus.asier.personalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eus.asier.personalproject.databinding.FragmentRecyclerBinding;
import eus.asier.personalproject.databinding.ViewholderTeamBinding;

public class RecyclerFragment extends Fragment {

    private FragmentRecyclerBinding binding;
    private TeamsViewModel teamsViewModel;
    private NavController navController;
    private List<Element> elements = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        teamsViewModel = new ViewModelProvider(requireActivity()).get(TeamsViewModel.class);
        navController = Navigation.findNavController(view);

        ElementsAdapter elementsAdapter = new ElementsAdapter();

        binding.recyclerView.setAdapter(elementsAdapter);

        BottomNavigationItemView navigationAdd = requireActivity().findViewById(R.id.navigation_add);
        BottomNavigationItemView navigationFav = requireActivity().findViewById(R.id.navigation_favorites);
        BottomNavigationItemView navigationHome = requireActivity().findViewById(R.id.navigation_home);
        Toolbar navigationLogout = requireActivity().findViewById(R.id.toolbar);

        teamsViewModel.obtain().observe(getViewLifecycleOwner(), new Observer<List<Element>>() {
            @Override
            public void onChanged(List<Element> elements) {
                elementsAdapter.submitList(elements);
                RecyclerFragment.this.elements = elements; // Store the elements in the class variable
            }
        });

        navigationHome.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                teamsViewModel.obtain().observe(getViewLifecycleOwner(), new Observer<List<Element>>() {
                    @Override
                    public void onChanged(List<Element> elements) {
                        elementsAdapter.submitList(elements);
                        RecyclerFragment.this.elements = elements;
                    }
                });

                navigationHome.setChecked(true);
                navigationAdd.setChecked(false);
                navigationFav.setChecked(false);
            }
        });

        navigationAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_homeFragment_to_newElementFragment);

                navigationHome.setChecked(false);
                navigationAdd.setChecked(true);
                navigationFav.setChecked(false);
            }
        });

        navigationFav.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                List<Element> favoriteElements = new ArrayList<>();
                for (Element element : elements) {
                    if (element.isFavorite()) {
                        favoriteElements.add(element);
                    }
                }
                elementsAdapter.submitList(favoriteElements);

                navigationHome.setChecked(false);
                navigationAdd.setChecked(false);
                navigationFav.setChecked(true);
            }
        });

        navigationLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (navController != null) {
                    navController.navigate(R.id.action_homeFragment_to_loginFragment3);
                } else {
                    Log.e("RecyclerFragment", "NavController is null");
                }
            }
        });

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Element element = elementsAdapter.getElement(position);
                teamsViewModel.delete(element);
            }
        };

        new ItemTouchHelper(simpleCallback).attachToRecyclerView(binding.recyclerView);
    }

    class ElementViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderTeamBinding binding;

        ElementViewHolder(ViewholderTeamBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Element element) {
            binding.name.setText(element.getName());
            binding.imageView.setImageResource(element.getImage());

            if (element.isFavorite()) {
                binding.star.setImageResource(R.drawable.ic_star);
                binding.star.setColorFilter(ContextCompat.getColor(binding.star.getContext(), R.color.yellow)); // Use the appropriate color resource for yellow
            } else {
                binding.star.setImageResource(R.drawable.ic_star_border);
                binding.star.setColorFilter(null);
            }

            binding.star.setOnClickListener(v -> {
                if (element.isFavorite()) {
                    element.setFavorite(false);
                    binding.star.setImageResource(R.drawable.ic_star_border);
                    binding.star.setColorFilter(null);
                    teamsViewModel.update(element);
                } else {
                    element.setFavorite(true);
                    binding.star.setImageResource(R.drawable.ic_star);
                    binding.star.setColorFilter(ContextCompat.getColor(binding.star.getContext(), R.color.yellow));
                    teamsViewModel.update(element);
                }
            });

            binding.getRoot().setOnClickListener(v -> {
                teamsViewModel.select(element);
                navController.navigate(R.id.action_homeFragment_to_detailFragment);
            });

            String[] results = {"win", "draw", "lost", "win", "draw"};
            List<String> resultList = Arrays.asList(results);

            for (int i = 0; i < 5; i++) {
                String result = resultList.get(i);

                switch (i) {
                    case 0:
                        binding.one.setText(result.substring(0, 1).toUpperCase());
                        setColor(binding.one, result);
                        break;
                    case 1:
                        binding.two.setText(result.substring(0, 1).toUpperCase());
                        setColor(binding.two, result);
                        break;
                    case 2:
                        binding.three.setText(result.substring(0, 1).toUpperCase());
                        setColor(binding.three, result);
                        break;
                    case 3:
                        binding.four.setText(result.substring(0, 1).toUpperCase());
                        setColor(binding.four, result);
                        break;
                    case 4:
                        binding.five.setText(result.substring(0, 1).toUpperCase());
                        setColor(binding.five, result);
                        break;
                }
            }
        }

        private void setColor(TextView textView, String result) {
            switch (result) {
                case "win":
                    textView.setBackgroundColor(ContextCompat.getColor(textView.getContext(), R.color.green));
                    break;
                case "draw":
                    textView.setBackgroundColor(ContextCompat.getColor(textView.getContext(), R.color.yellow));
                    break;
                case "lost":
                    textView.setBackgroundColor(ContextCompat.getColor(textView.getContext(), R.color.red));
                    break;
            }
        }
    }

    private class ElementsAdapter extends RecyclerView.Adapter<ElementViewHolder> {
        private List<Element> elements;

        @NonNull
        @Override
        public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ViewholderTeamBinding itemBinding = ViewholderTeamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ElementViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
            Element element = elements.get(position);
            holder.bind(element);
        }

        @Override
        public int getItemCount() {
            return elements != null ? elements.size() : 0;
        }

        @SuppressLint("NotifyDataSetChanged")
        void submitList(List<Element> elements) {
            this.elements = elements;
            notifyDataSetChanged();
        }

        Element getElement(int position) {
            return elements.get(position);
        }
    }
}
