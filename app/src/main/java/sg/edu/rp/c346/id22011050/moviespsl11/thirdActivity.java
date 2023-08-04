package sg.edu.rp.c346.id22011050.moviespsl11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class thirdActivity extends AppCompatActivity {
    EditText etTitle, etGenre,etYear, etSongID;
    Button btnCancel, btnUpdate, btnDelete;
    Spinner spinnerRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        etTitle = findViewById(R.id.etTitleM);
        etGenre = findViewById(R.id.etGenreM);
        etYear = findViewById(R.id.etYearM);
        btnCancel = findViewById(R.id.btnCancel);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        spinnerRating = findViewById(R.id.spinner2);
        etSongID = findViewById(R.id.etIDm);

        Intent i = getIntent();
        Movie data =  (Movie) i.getSerializableExtra("movie");
        etSongID.setText(String.valueOf(data.getId()));
        etTitle.setText(data.getTitle());
        etGenre.setText(data.getGenre());
        etYear.setText(String.valueOf(data.getYear()));
        spinnerRating.setSelection(getIndex(spinnerRating, data.getRating()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(thirdActivity.this);
                String selectedRate = spinnerRating.getSelectedItem().toString();
                if(selectedRate =="G"){
                    data.setTitle(etTitle.getText().toString());
                    data.setGenre(etGenre.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating("G");
                    db.updateMovie(data);
                    db.close();
                    finish();
                }else if (selectedRate =="M18"){
                    data.setTitle(etTitle.getText().toString());
                    data.setGenre(etGenre.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating("M18");
                    db.updateMovie(data);
                    db.close();
                    finish();
                }else if (selectedRate =="NC16"){
                    data.setTitle(etTitle.getText().toString());
                    data.setGenre(etGenre.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating("NC16");
                    db.updateMovie(data);
                    db.close();
                    finish();
                }else if (selectedRate =="PG"){
                    data.setTitle(etTitle.getText().toString());
                    data.setGenre(etGenre.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating("PG");
                    db.updateMovie(data);
                    db.close();
                    finish();
                }else if (selectedRate =="PG13"){
                    data.setTitle(etTitle.getText().toString());
                    data.setGenre(etGenre.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating("PG13");
                    db.updateMovie(data);
                    db.close();
                    finish();
                }else{
                    data.setTitle(etTitle.getText().toString());
                    data.setGenre(etGenre.getText().toString());
                    data.setYear(Integer.parseInt(etYear.getText().toString()));
                    data.setRating("R21");
                    db.updateMovie(data);
                    db.close();
                    finish();
                }


            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdActivity.this, secondActivity.class);
                startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(thirdActivity.this);
                dbh.deleteMovies(data.getId());
                Intent intent = new Intent(thirdActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private int getIndex(Spinner spinnerRating, String rating) {
        for (int i=0;i<spinnerRating.getCount();i++){
            if (spinnerRating.getItemAtPosition(i).toString().equalsIgnoreCase(rating)){
                return i;
            }
        }
        return 0;
    }
}