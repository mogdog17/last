package qslide.example.lv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Dag2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dag2);

        Button newAd = (Button)findViewById(R.id.AdB);
        final ListView listView = (ListView) findViewById(R.id.Daglist);

        newAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dag2.this, Dag2NewPodt.class);
                startActivity(intent);
            }
        });
    }
}
