package paauw.week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        final Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
        final Bundle b      = new Bundle();
        final EditText edit = (EditText)findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                b.putString("naam", edit.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
