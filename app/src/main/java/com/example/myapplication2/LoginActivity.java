package com.example.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.dto.CosoRequestDTO;
import com.example.myapplication2.dto.CosoResponeseDTO;
import com.example.myapplication2.dto.ListgetAllCosoResponeseDTO;
import com.example.myapplication2.dto.LoginRequestDTO;
import com.example.myapplication2.dto.LoginResponeseDTO;
import com.example.myapplication2.dto.RegisterRequestDTO;
import com.example.myapplication2.dto.RegisterResponeseDTO;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    SignInButton loginwithGG;
    private SignInClient oneTapClient;
    private BeginSignInRequest signUpRequest;
    IRetrofit iRetrofit;
    String email;
    String name;
    Uri avatar;

    Spinner spinner;
//    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ArrayList<Integer> listIdCoso = new ArrayList<>();
    int idcoso;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginwithGG = findViewById(R.id.loginwithGG);
        spinner = findViewById(R.id.spinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                // Xử lý khi người dùng chọn một mục từ dropdown
                idcoso = listIdCoso.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Xử lý khi không có mục nào được chọn
            }
        });

        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        oneTapClient = Identity.getSignInClient(this);
        signUpRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                        .setSupported(true)
                        .setServerClientId(getString(R.string.default_web_client_id))
                        .setFilterByAuthorizedAccounts(false)
                        .build())
                .build();
        loginwithGG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "onclick: sdf");
                oneTapClient.beginSignIn(signUpRequest).addOnSuccessListener(LoginActivity.this, new OnSuccessListener<BeginSignInResult>() {
                            @Override
                            public void onSuccess(BeginSignInResult beginSignInResult) {
                                try {
                                    IntentSenderRequest intentSenderRequest = new IntentSenderRequest.Builder(beginSignInResult.getPendingIntent().getIntentSender()).build();
                                    startActivityForResult.launch(intentSenderRequest);
                                } catch (Exception e){
                                    Log.i("TAG", "onSuccess: " + e);

                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("TAG", "onFailure: " + e);
                                Toast.makeText(LoginActivity.this,"Error this"+ e,Toast.LENGTH_LONG).show();                            }
                        });
            }
        });
    }
    ActivityResultLauncher<IntentSenderRequest> startActivityForResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult()
            , new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK)
                    {
                        try {
                            SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(result.getData());
                            String idToken = credential.getGoogleIdToken();
                            if (idToken !=null) {
                                email = credential.getId();
                                avatar = credential.getProfilePictureUri();
                                name = credential.getDisplayName();
                                String[] tachChuoi = email.split("@");
                                String phanConLai = tachChuoi[1];
                                if(!phanConLai.equals("fpt.edu.vn")){
                                    Toast.makeText(LoginActivity.this,"không phải tài khoản FPT vui lòng chọn tài khoản khác.", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    LoginRequestDTO request = new LoginRequestDTO(email);
                                    iRetrofit.login(request).enqueue(logins);

                                }


                            }
                        } catch (Exception e) {
                            Log.e("TAG", "onFailure: ", e );
                            Toast.makeText(LoginActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                        }
                    }else {}
                }
    });
    @Override
    protected void onResume() {
        super.onResume();
        iRetrofit.getAllCoso().enqueue(getallcoso);
    }

    Callback<ListgetAllCosoResponeseDTO> getallcoso = new Callback<ListgetAllCosoResponeseDTO>() {
        @Override
        public void onResponse(Call<ListgetAllCosoResponeseDTO> call, Response<ListgetAllCosoResponeseDTO> response) {
            if (response.isSuccessful()) {
                ListgetAllCosoResponeseDTO reponeseDTO = response.body();
                List<ListgetAllCosoResponeseDTO.getAllCosoResponeseDTO> listAllcoso = reponeseDTO.getAllcoso();
                ArrayList<String> listNameCoso = new ArrayList<>();
                for (int i = 0; i < listAllcoso.size(); i++) {
                    listNameCoso.add(listAllcoso.get(i).getName());
                    listIdCoso.add(listAllcoso.get(i).getId());
                }
                String[] newItems = new String[listNameCoso.size()];
                for (int i = 0; i < listNameCoso.size(); i++) {
                    newItems[i] = listNameCoso.get(i);
                }
                adapter = new ArrayAdapter<>(LoginActivity.this, android.R.layout.simple_spinner_dropdown_item, newItems);
                spinner.setAdapter(adapter);
            }
        }
        @Override
        public void onFailure(Call<ListgetAllCosoResponeseDTO> call, Throwable t) {
            Toast.makeText(LoginActivity.this, "khong thanh cong" + t, Toast.LENGTH_SHORT).show();
            Log.i("TAG", "onFailure: "+ t);
        }
    };

    Callback<LoginResponeseDTO> logins = new Callback<LoginResponeseDTO>() {
        @Override
        public void onResponse(Call<LoginResponeseDTO> call, Response<LoginResponeseDTO> response) {
            if (response.isSuccessful()) {
                LoginResponeseDTO reponeseDTO = response.body();
                if(reponeseDTO.isStatus()){
                    //kiem tra coso
                    id = reponeseDTO.getId();
                    CosoRequestDTO request1 = new CosoRequestDTO(reponeseDTO.getId(),idcoso);
                    iRetrofit.getCoSonn(request1).enqueue(checkcoso);
                } else{
                    RegisterRequestDTO request1 = new RegisterRequestDTO(email,name,avatar+"");
                    iRetrofit.register(request1).enqueue(register);
                }
            }
        }
        @Override
        public void onFailure(Call<LoginResponeseDTO> call, Throwable t) {
        }
    };

    Callback<RegisterResponeseDTO> register = new Callback<RegisterResponeseDTO>() {
        @Override
        public void onResponse(Call<RegisterResponeseDTO> call, Response<RegisterResponeseDTO> response) {
            if (response.isSuccessful()) {
                RegisterResponeseDTO reponeseDTO = response.body();
                if(reponeseDTO.isStatus()){
                    //chuyen sang login
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id",id + "");
                    intent.putExtra("email", email);
                    intent.putExtra("name", name);
                    intent.putExtra("avatar", avatar+"");
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(LoginActivity.this, "ko thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        }
        @Override
        public void onFailure(Call<RegisterResponeseDTO> call, Throwable t) {
        }
    };
    Callback<CosoResponeseDTO> checkcoso = new Callback<CosoResponeseDTO>() {
        @Override
        public void onResponse(Call<CosoResponeseDTO> call, Response<CosoResponeseDTO> response) {
            if (response.isSuccessful()) {
                CosoResponeseDTO reponeseDTO = response.body();
                if(reponeseDTO.isStatus()){
                    //chuyen sang login
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("name", name);
                    intent.putExtra("avatar", avatar+"");
                    startActivity(intent);
                    finish();
                } else{
                    Toast.makeText(LoginActivity.this, "Bạn đã chọn sai cơ sở", Toast.LENGTH_SHORT).show();
                }
            }
        }
        @Override
        public void onFailure(Call<CosoResponeseDTO> call, Throwable t) {
        }
    };

}
