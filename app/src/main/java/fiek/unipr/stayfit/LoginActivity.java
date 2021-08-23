package fiek.unipr.stayfit;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import static fiek.unipr.stayfit.RegisterActivity.hideSoftKeyboard;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnRegister, btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupUI(findViewById(R.id.realtive_id2));

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivityIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(loginActivityIntent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int retLogin = LoginUser(etEmail.getText().toString(), etPassword.getText().toString());
                if(retLogin==-1)
                    Toast.makeText(LoginActivity.this, getString(R.string.user_not_found),Toast.LENGTH_LONG).show();
                else if(retLogin == 0)
                {
                    //ContentView contentView = findViewById(R.id.realtive_id1);
                    Toast.makeText(LoginActivity.this, getString(R.string.wrong_credentials),Toast.LENGTH_LONG).show();
                    //Snackbar.make((View) contentView, R.string.wrong_credentials, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Successfully logged in!",Toast.LENGTH_LONG).show();
                    Intent mainActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                    //mainActivityIntent.putExtra("email",etEmail.getText().toString());
                    startActivity(mainActivityIntent);
                }
            }
        });
    }

    private int LoginUser(String email, String password)
    {
        SQLiteDatabase objDb = new DatabaseHelper(LoginActivity.this).getReadableDatabase();
        Cursor cursor = objDb.query(DatabaseModelHelper.UsersTable,new String[]{DatabaseModelHelper.UsersEmail,DatabaseModelHelper.UsersPassword},DatabaseModelHelper.UsersEmail+"=?",
                new String[]{email},"","","");

        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            String dbUserMail = cursor.getString(0);
            String dbUserPassword = cursor.getString(1);

            cursor.close();
            objDb.close();
            if(password.equals(dbUserPassword))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        return -1;
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(LoginActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
}