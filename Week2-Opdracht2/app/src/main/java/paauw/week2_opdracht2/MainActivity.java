package paauw.week2_opdracht2;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import paauw.week2_opdracht2.database.DatabaseHelper;
import paauw.week2_opdracht2.database.DatabaseInfo;
import paauw.week2_opdracht2.database.Login;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Login> users = new ArrayList<Login>();

        users.add(new Login("Maarten Paauw",   "geheim_gek"));
        users.add(new Login("Zowie van Geest", "helemaal_geheim_gek"));
        users.add(new Login("Gerson Straver",  "1k_b3n_63rr13_1k_5ch1jf_4l71jd_p3r0n63luk_1n_1337_744l"));

        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);

        for (Login user: users)
        {
            ContentValues values = new ContentValues();
            values.put(DatabaseInfo.UserColumn.USERNAME, user.getUsername());
            values.put(DatabaseInfo.UserColumn.PASSWORD, user.getPassword());
            dbHelper.insert(DatabaseInfo.UserTable.USER, null, values);
        }

        Button show = (Button) findViewById(R.id.show);

        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondaryActivity.class));
            }
        });
    }
}
