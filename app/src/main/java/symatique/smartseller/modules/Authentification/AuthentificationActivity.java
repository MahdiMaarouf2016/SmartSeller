package symatique.smartseller.modules.Authentification;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import symatique.smartseller.R;
import symatique.smartseller.bases.RetrofitBases;
import symatique.smartseller.data.Utilisateurs.AuthenticationResponse;
import symatique.smartseller.data.Utilisateurs.Livreur;
import symatique.smartseller.modules.Factures.DialogPrintFacture;
import symatique.smartseller.modules.Home.HomeActivity;
import symatique.smartseller.services.RetrofitService.ApiService;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthentificationActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {


    public static AuthenticationResponse authenticationResponse;
    private final int REQUEST_READ_PHONE_STATE = 1;
    @BindView(R.id.appCompatImageView) AppCompatImageView appCompatImageView;
    @BindView(R.id.txtedt_auth_login) AppCompatEditText txtedtAuthLogin;
    @BindView(R.id.txtedt_auth_password) ShowHidePasswordEditText txtedtAuthPassword;
    @BindView(R.id.btn_auth_enter) AppCompatButton btnAuthEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
        ButterKnife.bind(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        tofo:
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    authentifier();
                }
                break;

            default:
                break;
        }
    }

    @OnClick(R.id.btn_auth_enter)
    public void btnAuthEnterOnClick() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        } else {
            authentifier();
        }
    }

    private void authentifier() {
        String code = txtedtAuthLogin.getText().toString();
        String password = txtedtAuthPassword.getText().toString();
        String device_imei = ((TelephonyManager) getSystemService(this.TELEPHONY_SERVICE)).getDeviceId();
        Log.v("IMEI", "Message : " + device_imei);
        if (code.isEmpty()) {
            Toast.makeText(this, " Saisire votre code d'authentification ! svp", Toast.LENGTH_LONG).show();
        } else if (password.isEmpty()) {
            Toast.makeText(this, "Saisire votre mot de passe ! svp", Toast.LENGTH_LONG).show();
        } else {
            new ApiService().getAuthentificated(code, encryptMD5(password), device_imei, RetrofitBases.APP_VERSION).enqueue(new Callback<AuthenticationResponse>() {
                @Override
                public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(getApplication(), "Connexion internet attendu ", Toast.LENGTH_LONG).show();
                    } else {
                        AuthenticationResponse authenticationResponse = response.body();
                        AuthentificationActivity.authenticationResponse = authenticationResponse;
                        switch (authenticationResponse.getEtatCompte()) {
                            case 0: {
                                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                                startActivity(intent);
                            }
                            break;
                            case 1: {
                                Toast.makeText(getApplication(), " Votre compte a étè blocké ! , Contacter votre administration", Toast.LENGTH_LONG).show();
                            }
                            case 2: {
                                Toast.makeText(getApplication(), "Authentification errorné : Mot de passe incorrecte ", Toast.LENGTH_LONG).show();
                            }
                            case 3: {
                                Toast.makeText(getApplication(), "Authentification errorné : Ce compte n est pas inscrit dans notre reseaux ", Toast.LENGTH_LONG).show();
                            }
                            case 4: {
                                Toast.makeText(getApplication(), "Service est injoignable pour le moment ", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                }

                @Override
                public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                    ApiService.standartNotifyFailerResponse(t);
                    Toast.makeText(getApplication(), " Aucnune connexion internet !, Merci de demarrer votre donnees mobile", Toast.LENGTH_LONG).show();
                }

            });

        }
    }

    private String encryptMD5(String pattern) {
        String password = null;
        MessageDigest mdEnc;
        try {
            mdEnc = MessageDigest.getInstance("MD5");
            mdEnc.update(pattern.getBytes(), 0, pattern.length());
            pattern = new BigInteger(1, mdEnc.digest()).toString(16);
            while (pattern.length() < 32) {
                pattern = "0" + pattern;
            }
            password = pattern;
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return password;
    }

}
