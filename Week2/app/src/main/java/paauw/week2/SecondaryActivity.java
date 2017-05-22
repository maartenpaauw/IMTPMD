package paauw.week2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Bundle b       = getIntent().getExtras();
        String value   = b.getString("naam");
        EditText field = (EditText) findViewById(R.id.text_show);

        field.setText(value);
    }
}
