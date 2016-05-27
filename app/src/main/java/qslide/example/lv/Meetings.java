package qslide.example.lv;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Meetings extends AppCompatActivity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listv_meetings);

        Intent intent = getIntent();
        final ArrayList<UserInfo> list =  (ArrayList<UserInfo>) intent.getSerializableExtra("dataset"); //get arraylist of userInfo
        final ListView listView = (ListView) findViewById(R.id.list);

        MyAdapter myAdapter = new MyAdapter(this, R.layout.row, list);//this class, xml of row, list
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //parent-: The AdapterView where the click happened.
                LayoutInflater li = LayoutInflater.from(parent.getContext());// fulfill the layout in the xml
                View view = li.inflate(R.layout.dialog, null);
                final TextView userInput = (TextView) view.findViewById(R.id.info);

                AlertDialog.Builder builder = new AlertDialog.Builder(
                        parent.getContext());

                // set prompts.xml to alertdialog builder
                builder.setView(view);

                userInput.setText(list.get(position).Details);
                // set dialog message
                builder.setPositiveButton("חזור", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = builder.create();

                // show it
                alertDialog.show();
            }
        });
                // set prompts.xml to alertdialog builder
//                builder.setView(promptsView);

//                final TextView userInput = (TextView) promptsView
//                        .findViewById(R.id.info);


    }
}

class MyAdapter extends ArrayAdapter<UserInfo> {


    public MyAdapter(Context context, int resource, List<UserInfo> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row,parent,false);
            //builds the row

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.name); // change holder.xxx and findview...
            holder.Style = (TextView) convertView.findViewById(R.id.Style); // change holder.xxx and findview...
            holder.Date = (TextView) convertView.findViewById(R.id.Date);  // change holder.xxx and findview...
            holder.location = (TextView) convertView.findViewById(R.id.location);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();


        UserInfo userInfo = getItem(position);
       //we dont need findviewbyid now:
        holder.name.setText(userInfo.Name);    // change holder.xxx
        holder.location.setText(userInfo.Location);// change holder.xxx
        holder.Date.setText(userInfo.Time);
        holder.Style.setText(String.valueOf(userInfo.Style));    // change holder.xxx

        return convertView;
    }
}

class ViewHolder {
    public TextView name; // change
    public TextView Style;   // change
    public TextView Date; // change
    public TextView location;
}

