package paauw.week2_opdracht2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import paauw.week2_opdracht2.database.DatabaseHelper;
import paauw.week2_opdracht2.database.DatabaseInfo;

public class SecondaryActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        DatabaseHelper dbHelper = DatabaseHelper.getHelper(this);

        Cursor rs = dbHelper.query(DatabaseInfo.UserTable.USER, new String[]{"*"}, null, null, null, null, null);

        EditText users = (EditText) findViewById(R.id.users);

        while (rs.moveToNext())
        {
            String username = rs.getString(rs.getColumnIndex(DatabaseInfo.UserColumn.USERNAME));
            String password = rs.getString(rs.getColumnIndex(DatabaseInfo.UserColumn.PASSWORD));

            String user = username + ": " + password;

            users.append(user + "\n");
        }

        Toast toast = Toast.makeText(getApplicationContext(), "Succesvol de gebruikers opgehaald", Toast.LENGTH_LONG);
        toast.show();
    }
}
