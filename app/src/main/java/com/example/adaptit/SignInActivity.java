//package com.example.adaptit;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.view.View;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.socialchat.databinding.ActivitySignInBinding;
//import com.example.socialchat.utilities.Constants;
//import com.example.socialchat.utilities.PreferenceManager;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//public class SignInActivity extends AppCompatActivity
//{
//    private ActivitySignInBinding binding;
//    private PreferenceManager preferenceManager;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        binding = ActivitySignInBinding.inflate(getLayoutInflater());
//        preferenceManager = new PreferenceManager(getApplicationContext());
//
//        if(preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)){
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//
//        setContentView(binding.getRoot());
//        setListeners();
//    }
//
//    private void setListeners(){
//        binding.lblCreateNewAccount.setOnClickListener(v ->
//                startActivity(new Intent(getApplicationContext(), SignUpActivity.class)));
//
//        binding.textInputEditTextEnterEmail.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                binding.textInputLayoutEnterEmail.setErrorEnabled(false);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        binding.textInputEditTextEnterPassword.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
//            {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                binding.textInputLayoutEnterPassword.setErrorEnabled(false);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//        binding.btnSignIn.setOnClickListener(v -> {
//            if(isValidData())
//                signIn();
//            else
//                Toast.makeText(getApplicationContext(), "Check that data is valid", Toast.LENGTH_SHORT).show();
//        });
//    }
//
//    private void signIn(){
//        loading(true);
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//        assert binding.textInputEditTextEnterEmail.getText() != null;
//        assert binding.textInputEditTextEnterPassword.getText() != null;
//        String email = binding.textInputEditTextEnterEmail.getText().toString();
//        String password = binding.textInputEditTextEnterPassword.getText().toString();
//
//        db.collection(Constants.KEY_COLLECTION_USERS)
//                .whereEqualTo(Constants.KEY_EMAIL, email)
//                .whereEqualTo(Constants.KEY_PASSWORD, password)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if(task.isSuccessful() && task.getResult() != null && task.getResult().getDocuments().size() > 0)
//                    {
//                        DocumentSnapshot documentSnapshot = task.getResult().getDocuments().get(0);
//                        preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true);
//                        preferenceManager.putString(Constants.KEY_USER_ID, documentSnapshot.getId());
//                        preferenceManager.putString(Constants.KEY_NAME, documentSnapshot.getString(Constants.KEY_NAME));
//                        preferenceManager.putString(Constants.KEY_EMAIL, documentSnapshot.getString(Constants.KEY_EMAIL));
//                        preferenceManager.putString(Constants.KEY_IMAGE, documentSnapshot.getString(Constants.KEY_IMAGE));
//
//                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(intent);
//                    } else {
//                        loading(false);
//                        Toast.makeText(getApplicationContext(), "Unable to sign in. Incorrect email or password", Toast.LENGTH_SHORT).show();
//
//                        binding.textInputLayoutEnterEmail.setErrorEnabled(true);
//                        binding.textInputLayoutEnterEmail.setError("****");
//                        binding.textInputLayoutEnterPassword.setErrorEnabled(true);
//                        binding.textInputLayoutEnterPassword.setError("****");
//                    }
//                });
//    }
//
//    private void loading(@NonNull Boolean isLoading){
//        if(isLoading){
//            binding.btnSignIn.setVisibility(View.INVISIBLE);
//            binding.signInProgressBar.setVisibility(View.VISIBLE);
//        } else {
//            binding.btnSignIn.setVisibility(View.VISIBLE);
//            binding.signInProgressBar.setVisibility(View.INVISIBLE);
//        }
//    }
//
//    @NonNull
//    private Boolean isValidData()
//    {
//        assert binding.textInputEditTextEnterEmail.getText() != null;
//        assert binding.textInputEditTextEnterPassword.getText() != null;
//        String email = binding.textInputEditTextEnterEmail.getText().toString();
//        String password = binding.textInputEditTextEnterPassword.getText().toString();
//        boolean flag = true;
//
//        if(email.isEmpty()){
//            binding.textInputLayoutEnterEmail.setErrorEnabled(true);
//            binding.textInputLayoutEnterEmail.setError("Email is required");
//            flag = false;
//        }
//        if(password.isEmpty()){
//            binding.textInputLayoutEnterPassword.setErrorEnabled(true);
//            binding.textInputLayoutEnterPassword.setError("Password is required");
//            flag = false;
//        }
//
//        return flag;
//    }
//}