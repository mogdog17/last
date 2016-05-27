package qslide.example.lv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MeetingsActivity extends AppCompatActivity {
    EditText txtName,txtLocation, txtdetails;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.MeetingsActivity);

        Button contnu = (Button)findViewById(R.id.btn);
        txtName = (EditText)findViewById(R.id.name);
        txtLocation = (EditText)findViewById(R.id.location);
        txtdetails = (EditText)findViewById(R.id.details);
        spinner = (Spinner)findViewById(R.id.spinner);
        final ArrayList<UserInfo> list = new ArrayList<>(); // list contains userinfo

        contnu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateFormat dayFormat = new SimpleDateFormat("dd.MM, HH:mm");
                UserInfo user1 = new UserInfo();

                user1.Location=txtLocation.getText().toString();
                user1.Name = txtName.getText().toString();
                user1.Time = dayFormat.format(Calendar.getInstance().getTime());
                user1.Style = spinner.getSelectedItem().toString();
                user1.Details = txtdetails.getText().toString();

                list.add(0, user1);// push to location 0

                Intent intent2 = new Intent(MeetingsActivity.this, Meetings.class);
                intent2.putExtra("dataset", list);// can be sent because it is ArrayList<UserInfo>, UserInfo is seralizable
                startActivity(intent2);
            }
        });
    }
}
