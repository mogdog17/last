package qslide.example.lv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LiveReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);

    }


    public void onClickgotoCaughtFishActivity(View view) {
Intent intent1=new Intent(this, CaughtFishActivity.class);
        startActivity(intent1);
    }
    public void onClickgotoNoFish(View view) {
        Intent intent2=new Intent(this, NoFishActivity.class);
        startActivity(intent2);

    }

}
