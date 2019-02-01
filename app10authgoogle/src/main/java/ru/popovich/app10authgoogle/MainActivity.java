package ru.popovich.app10authgoogle;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

/**
 * Google Sign-In for Android
 * https://developers.google.com/identity/sign-in/android/start-integrating
 * https://developers.google.com/identity/sign-in/android/sign-in
 *
 * https://developers.google.com/android/guides/client-auth
 * https://console.developers.google.com/
 *
 * Examples:
 * https://github.com/googlesamples/google-services
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int RC_SIGN_IN = 1;
    private static final String TAG = "MainActivity";

    // Text field
    TextView textView;

    GoogleSignInOptions signInOptions;
    GoogleSignInClient signInClient;
    SignInButton signInButton;

    @Override
    protected void onStart() {
        super.onStart();

        // Инициализация кнопки логирования Google
        signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);
        signInButton.setOnClickListener(this);

        // Инициализация textView
        textView = findViewById(R.id.textView); textView.setOnClickListener(this);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Настройка логирования по запросу ID пользователя, почты, и базовой настройки профиля (DEFAULT_SIGN_IN).
        signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        signInClient = GoogleSignIn.getClient(this,signInOptions);


    }

    private void updateUI(GoogleSignInAccount account) {

        if(account != null)
        textView.setText(account.getDisplayName());

//        Log.d(TAG, "account.getEmail(): " + account.getEmail());
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sign_in_button:
                signIn();
                break;
            default:
                break;
        }
    }

    private void signIn() {
        Intent intent = signInClient.getSignInIntent();
        startActivityForResult(intent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try{
            GoogleSignInAccount account = task.getResult(ApiException.class);
            updateUI(account);
        } catch (ApiException e){
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            updateUI(null);
        }
    }
}
