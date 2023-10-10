package eus.asier.masterdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eus.asier.masterdetail.databinding.FragmentRecyclerBinding;
import eus.asier.masterdetail.databinding.ViewholderElementBinding;

public class RecyclerFragment extends Fragment {

    private FragmentRecyclerBinding binding;
    private ElementsViewModel elementsViewModel;
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRecyclerBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        elementsViewModel = new ViewModelProvider(requireActivity()).get(ElementsViewModel.class);
        navController = Navigation.findNavController(view);

        ElementsAdapter elementsAdapter = new ElementsAdapter();
        binding.recyclerView.setAdapter(elementsAdapter);

        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        elementsViewModel.obtain().observe(getViewLifecycleOwner(), elements -> {
            elementsAdapter.establishList(elements);
        });
    }

    class ElementsAdapter extends RecyclerView.Adapter<ElementViewHolder> {
        private List<Element> elements;

        @NonNull
        @Override
        public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            ViewholderElementBinding itemBinding = ViewholderElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ElementViewHolder(itemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
            Element element = elements.get(position);

            holder.binding.name.setText(element.name);
            holder.binding.ratingBar.setRating(element.rating);
            holder.binding.imageView.setImageResource(element.image);

            holder.itemView.setOnClickListener(v -> {
                elementsViewModel.select(element);
                navController.navigate(R.id.action_recyclerFragment_to_detailFragment);
                //Delete
                navController.navigate(R.id.action_recyclerFragment_to_newElementFragment);
                //Add
                navController.navigate(R.id.action_newElementFragment);
                //Delete
                navController.navigate(R.id.action_recyclerFragment_to_showElementFragment);
                //Add
                navController.navigate(R.id.action_showElementFragment);
            });
        }

        @Override
        public int getItemCount() {
            return elements != null ? elements.size() : 0;
        }

        public void establishList(List<Element> elements) {
            this.elements = elements;
            notifyDataSetChanged();
        }
    }

    static class ElementViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderElementBinding binding;

        public ElementViewHolder(ViewholderElementBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
