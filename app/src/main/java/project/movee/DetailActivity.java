package project.movee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import project.movee.fragments.DetailFragment;
import project.movee.models.Movie;

/**
 * Created by nickyg on 31/03/16.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("movie");
        DetailFragment detailFragment = DetailFragment.newInstance(movie);
        getSupportFragmentManager().beginTransaction().add(R.id.movie_detail_container,detailFragment).commit();

    }
}
