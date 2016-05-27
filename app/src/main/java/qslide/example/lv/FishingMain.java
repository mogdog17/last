package qslide.example.lv;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FishingMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_meetings);
    }

    public void onClickGoToMeetings(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}



