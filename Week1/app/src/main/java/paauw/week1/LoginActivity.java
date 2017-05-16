package paauw.week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText passwordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordView = (EditText) findViewById(R.id.password);

        String password = passwordView.getText().toString();

        passwordView.setError(getString(R.string.error_invalid_password));
    }
}
