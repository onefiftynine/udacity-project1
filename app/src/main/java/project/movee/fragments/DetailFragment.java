package project.movee.fragments;

import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import project.movee.R;
import project.movee.models.Movie;

/**
 * Created by nickyg on 31/03/16.
 */
public class DetailFragment extends Fragment {

    private static final String TAG = DetailFragment.class.getName();
    private Movie mMovie;

    public void DetailFragment(){

    }

    public static  DetailFragment newInstance(Movie movie){
        DetailFragment detailFragment = new DetailFragment();
        Bundle b = new Bundle();
        b.putParcelable("movie", movie);
        detailFragment.setArguments(b);
        return detailFragment;
     }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        final Movie movie = getArguments().getParcelable("movie");
        if(movie!=null) {
            TextView tv = (TextView) rootView.findViewById(R.id.name);
            tv.setText(movie.getOriginalTitle());
            ImageView poster = (ImageView)rootView.findViewById(R.id.poster);
            String image_url = "http://image.tmdb.org/t/p/w185" + movie.getPosterPath();
            Log.e(TAG, image_url);
            Picasso.with(getContext()).load(image_url).into(poster, PicassoPalette.with(image_url, poster));
            TextView ov =(TextView)rootView.findViewById(R.id.syn);
            ov.setText(movie.getOverview());
            TextView voteAverage =(TextView)rootView.findViewById(R.id.rating);
            voteAverage.setText(movie.getVoteAverage()+"/10");
            TextView release =(TextView)rootView.findViewById(R.id.release);
            release.setText(movie.getReleaseDate());




        }
        return rootView;
    }

}
