package eus.asier.masterdetail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.View;

import eus.asier.masterdetail.databinding.*;

public class MainActivity extends AppCompatActivity {
    private FragmentRecyclerBinding binding;
    private ElementsViewModel elementsViewModel;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.newElementFragment
                        || destination.getId() == R.id.detailFragment) {
                    binding.bottomNavView.setVisibility(View.GONE);
                } else {
                    binding.bottomNavView.setVisibility(View.VISIBLE);
                }

                if (destination.getId() == R.id.recyclerSearchFragment){
                    binding.searchView.setVisibility(View.VISIBLE);
                    binding.searchView.setIconified(false);
                    binding.searchView.requestFocusFromTouch();
                } else {
                    binding.searchView.setVisibility(View.GONE);
                }
            }
        });
    }
}