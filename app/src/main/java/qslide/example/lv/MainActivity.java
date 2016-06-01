package qslide.example.lv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] mOptionsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOptionsArray = new String[]{"דיווחים", "מפגשים", "דג2", "צ'אט"};
        ArrayAdapter myAdapter= new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mOptionsArray);

        ListView myList=(ListView) findViewById(R.id.listView);
        myList.setAdapter(myAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String option = mOptionsArray[position];
                Intent intent;
                switch(option){
                    case "דיווחים":
                        Intent I = new Intent(MainActivity.this, LiveReportActivity.class);
                        startActivity(I);
                        break;
                    case "מפגשים":
                        intent = new Intent(MainActivity.this, MeetingsActivity.class);
                        startActivity(intent);
                        break;
                    case "דג2":
                        intent = new Intent(MainActivity.this, Dag2.class);
                        startActivity(intent);
                        break;
                    case "צ'אט":
                        break;
                }
            }
        });
    }
}
