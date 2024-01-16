package eus.asier.personalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        navController = Navigation.findNavController(view);

        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (username.equals("admin") && password.equals("Admin123")) {
                Toast.makeText(requireContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_loginFragment3_to_homeFragment);
            } else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegister.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            if (username.length() >= 8 && password.length() >= 8) {
                Toast.makeText(requireContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                navController.navigate(R.id.action_loginFragment3_to_homeFragment);
            } else {
                Toast.makeText(requireContext(), "Username or password must have 8 characters", Toast.LENGTH_SHORT).show();
            }

        });


    }
}
