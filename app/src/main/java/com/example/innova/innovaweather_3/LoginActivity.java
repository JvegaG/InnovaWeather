package com.example.innova.innovaweather_3;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innova.innovaweather_3.ClassesAndInterfaces.Login.LoginInterface;
import com.example.innova.innovaweather_3.ClassesAndInterfaces.Login.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    // ************************* Comienzo del programa *************************

    //variable para ver si parametros (email, password) son nulos
    private UserLoginTask mAuthTask = null;

    // Variables Java para asociar con UI
    private Button btnIngresar, btnHelp;
    private EditText edtEmail, edtPassword;
    private View loginProgress, loginFormView;
    private TextInputLayout txtInputEmail, txtInputPassword;
    private ImageView imgLogo;
    private TextView txtCopy, txtTodos;

    // Constantes para el Basic Authentication
    private String USERNAME = "innovaweather@innovat.com.pe"; // Fijos
    private String PASSWORD = "7571c665c9e4d9d21ad99c801ed737cd"; // Fijos Md5

    //variable para obtener la respuesta
    private String respuestaError, idRequest, userNameRequest, emailUser, passUser;

    String url = "http://www.innovat.com.pe/InnovaWeather/Api/";

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create());

    Retrofit retrofit = builder.build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // --- Enlace de variables ---
        // Buttons
        btnIngresar = findViewById(R.id.btn_loginIn);
        btnHelp = findViewById(R.id.btn_help);
        // EditText
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        // Views
        loginFormView = findViewById(R.id.login_form);
        loginProgress = findViewById(R.id.loginProgress);
        // Image
        imgLogo = findViewById(R.id.img_Logo);
        // TextBoxes
        txtInputEmail = findViewById(R.id.float_label_email);
        txtInputPassword = findViewById(R.id.float_label_password);
        // Text
        txtCopy = findViewById(R.id.txt_copy);
        txtTodos = findViewById(R.id.txt_todos);

        // Acción del EditText Password
        edtPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    if (!isOnline()) {
                        showLoginError(getString(R.string.error_network)); // Solo para verificación de red
                        return false;
                    }
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        // Acción para el Botón - Ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOnline()) {
                    showLoginError(getString(R.string.error_network)); // Solo para verificación de red
                    return;
                }
                attemptLogin();
            }
        });

        // Acción para el Botón - Help
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Contáctese con nuestras oficinas\n" +
                        "Trujillo-Perú Telf.(044)618967", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Verficador de parametros ingresados en los TextViews
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }
        // Errores reseteados.
        edtEmail.setError(null);
        txtInputPassword.setError(null);
        // Guarda los valores contenidas de los editText (email, password) en variables String del login attempt.
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Verificar la validez de un password, si el usuario ingresa una contraseña.
        if (TextUtils.isEmpty(password)) {
            txtInputPassword.setError(getString(R.string.error_password_required));
            focusView = txtInputPassword;
            cancel = true;
        }

        // Verificar la validez de un email.
        if (TextUtils.isEmpty(email)) {
            edtEmail.setError(getString(R.string.error_email_required));
            focusView = edtEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            edtEmail.setError(getString(R.string.error_invalid_email));
            focusView = edtEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    /**
     * Login de Usuarios
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Integer> {

        private final String mEmail;
        private final String mPassword;

        // Constructor
        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Integer doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            LoginInterface userClient = retrofit.create(LoginInterface.class);

            String credenciales = USERNAME + ":" + PASSWORD;
            String authHeader = "Basic " + Base64.encodeToString(credenciales.getBytes(),Base64.NO_WRAP);
            Call<User> call = userClient.getUser(mEmail,mPassword,authHeader);

            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        respuestaError = response.body().getError();
                        userNameRequest = response.body().getData().getNombre();    // Nombre mostrado en el Header
                        idRequest = response.body().getData().getId(); // utilizado para los DID
                        passUser = mPassword;   // utilizado para los DID
                        emailUser = mEmail; //Email mostrado en el Header

                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    respuestaError = "Usuario no existe o datos incorrectos";
                }
            });

            try {
                showProgress(true);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(respuestaError.equals("0")){
                return 1;
            }else{
                return 2;
            }

            // TODO: register the new account here.
        }

        @Override
        protected void onPostExecute(final Integer success) {
            mAuthTask = null;
            showProgress(false);

            switch (success){
                case 1:
                    showNavigationView();
                    break;
                case 2:
                    showLoginError(respuestaError);
                    break;
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

    /**
     * Método para pasar a Navigation Activity
     */
    private void showNavigationView() {
        Intent toNavigationActiviy = new Intent(LoginActivity.this, NavigationActivity.class);
        toNavigationActiviy.putExtra("USERNAME", userNameRequest);
        toNavigationActiviy.putExtra("EMAIL", emailUser);
        toNavigationActiviy.putExtra("IDUSER", idRequest);
        toNavigationActiviy.putExtra("PASSUSER", passUser);
        startActivity(toNavigationActiviy);
        finish();
    }

    /**Método para validacíon de email
     * @param email
     * @return email.contains("@")
     */
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    /**
     * Muestra la barra de progreso UI y oculta el login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;
        btnHelp.setVisibility(visibility);
        txtCopy.setVisibility(visibility);
        txtTodos.setVisibility(visibility);
        imgLogo.setVisibility(visibility);
        loginFormView.setVisibility(visibility);
    }

    /**
     * Método para mostrar error
     */
    private void showLoginError (String error){
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    /**
     * Método para verificar el estado de la conexión de internet
     * @return activeNetwork
     */
    private boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnected();
    }

}
