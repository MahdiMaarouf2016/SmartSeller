package symatique.smartseller.modules.Authentification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Toast;
import com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.data.Utilisateurs.AuthenticationResponse;
import symatique.smartseller.data.Utilisateurs.Livreur;
import symatique.smartseller.modules.Home.HomeActivity;
import symatique.smartseller.services.RetrofitService.ApiService;

public class AuthentificationActivity extends AppCompatActivity {


    public static AuthenticationResponse authenticationResponse;

    @BindView(R.id.appCompatImageView) AppCompatImageView appCompatImageView;
    @BindView(R.id.txtedt_auth_login) AppCompatEditText txtedtAuthLogin;
    @BindView(R.id.txtedt_auth_password) ShowHidePasswordEditText txtedtAuthPassword;
    @BindView(R.id.btn_auth_enter) AppCompatButton btnAuthEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        ButterKnife.bind(this);
        setUp();
    }

    public void setUp() {

        AppCompatButton button = findViewById(R.id.btn_auth_enter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               authentifier();
            }
        });
    }

    public void setLivreur(Livreur livreur) {
        this.txtedtAuthLogin.setText(livreur.getEmail());
        this.txtedtAuthPassword.setText(livreur.getPassword());
    }

    public Livreur getLivreur() {
        return new Livreur();
    }

    public void authentifier(){

        Livreur livreur = getLivreur();
        ApiService apiService = new ApiService();

        apiService.getAuthentificated(livreur.getCode(),livreur.getPassword(),"0000","123").enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(getApplication(),"Connexion internet attendu ",Toast.LENGTH_LONG).show();
                }else{
                    AuthenticationResponse authenticationResponse = response.body();
                    AuthentificationActivity.authenticationResponse = authenticationResponse;
                    switch (authenticationResponse.getEtatCompte()){
                        case 0:{
                            Toast.makeText(getApplication(),"Authentification errorné",Toast.LENGTH_LONG).show();
                        }break;
                        case 1:{
                            Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                            startActivity(intent);
                        }
                        case 2:{

                        }
                        case 3:{

                        }
                        case 4:{

                        }
                    }
                }

            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                ApiService.standartNotifyFailerResponse(t);
                Toast.makeText(getApplication()," Connexion attendu ",Toast.LENGTH_LONG).show();
            }

        });
    }
}
