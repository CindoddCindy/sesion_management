package cindodcindy.sirihpinang.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK;

public class MainActivity extends AppCompatActivity {
    private EditText editText_nama, editText_password;
    private Button button_login;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "phoneKey";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_nama=findViewById(R.id.et_nama);
        editText_password=findViewById(R.id.et_password);
        button_login=findViewById(R.id.btn_masuk);

        if(SaveSharedPreference.getLoggedStatus(getApplicationContext())) {
            Intent intent = new Intent(getApplicationContext(), Logout.class);
            startActivity(intent);
        }




        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText_nama.getText().toString();
                String password = editText_password.getText().toString();


                userLogin(name,password);

            }
        });
    }

    public void userLogin(String name, String password){

        SaveSharedPreference.setLoggedIn(getApplicationContext(), true);
        Intent intent = new Intent(getApplicationContext(), Logout.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK |FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}
