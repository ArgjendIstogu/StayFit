package fiek.unipr.stayfit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etLastName, etEmail, etPassword;
    RadioButton radio_checked;
    RadioGroup radio_group;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUI(findViewById(R.id.realtive_id1));
        getSupportActionBar().hide();

        etName = findViewById(R.id.etName);
        etLastName = findViewById(R.id.etlastName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        radio_group = (RadioGroup)findViewById(R.id.radioSex);
        int selectedId = radio_group.getCheckedRadioButtonId();
        radio_checked = findViewById(selectedId);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(view -> {
            SQLiteDatabase objDB = new DatabaseHelper(RegisterActivity.this).getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseModelHelper.UsersName, etName.getText().toString());
            contentValues.put(DatabaseModelHelper.UsersLastName, etLastName.getText().toString());
            contentValues.put(DatabaseModelHelper.UsersEmail, etEmail.getText().toString());
            contentValues.put(DatabaseModelHelper.UsersPassword, etPassword.getText().toString());
            contentValues.put(DatabaseModelHelper.UsersGender, radio_checked.getText().toString());

            try {
                long id1 = objDB.insert(DatabaseModelHelper.UsersTable, null, contentValues);
                if(id1 >0){
                    Toast.makeText(RegisterActivity.this, getString(R.string.confirmation_message), Toast.LENGTH_LONG).show();
                    Intent loginActivityIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(loginActivityIntent);
                }
            } catch (Exception e) {
                Toast.makeText(RegisterActivity.this, getString(R.string.error_message), Toast.LENGTH_LONG).show();
            }
            finally {
                objDB.close();
            }
        });
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()){
            inputMethodManager.hideSoftInputFromWindow(
                    activity.getCurrentFocus().getWindowToken(),
                    0
            );
        }
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(RegisterActivity.this);
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