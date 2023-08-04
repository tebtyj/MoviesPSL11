package sg.edu.rp.c346.id22011050.moviespsl11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {
    Button btnShowPG13;
    Button btnback;
    ListView lv;
    ArrayList<Movie> al;
    ArrayAdapter<Movie> aa;
    CustomAdapter caMovie;
    protected void onResume() {
        super.onResume();
        al = new ArrayList<Movie>();
        caMovie = new CustomAdapter(this, R.layout.row, al);
        lv.setAdapter(caMovie);
        Intent i = getIntent();
        DBHelper db = new DBHelper(secondActivity.this);
        al.clear();
        al.addAll(db.getMovies());
        caMovie.notifyDataSetChanged();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnShowPG13 = findViewById(R.id.btnShowPG13);
        lv = findViewById(R.id.lv);
        btnback = findViewById(R.id.btnBack);


        btnShowPG13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(secondActivity.this);
                String filterText = "PG13";
                al.clear();
                al.addAll(dbh.getAllMovies(filterText));
                aa.notifyDataSetChanged();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Movie movie = al.get(position);
                Intent i = new Intent(secondActivity.this, thirdActivity.class);
                i.putExtra("movie", String.valueOf(movie));
                startActivity(i);
            }
        });


        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
