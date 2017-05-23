package paauw.week2_opdracht1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import paauw.week2_opdracht1.models.Login;

public class SecondaryActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle bundle = getIntent().getExtras();
        Login login   = (Login) bundle.getSerializable("login");

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        username.setText(login.getUsername());
        password.setText(login.getPassword());

        Context context = getApplicationContext();
        CharSequence text = "Succesvol ingelogd!";

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
