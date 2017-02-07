package project.movee.adaptor;

import com.github.florent37.picassopalette.PicassoPalette;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.movee.DetailActivity;
import project.movee.R;
import project.movee.models.Movie;

/**
 * Created by nickyg on 28/03/16.
 */
public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.ViewHolder> {

    private List<Movie> mDataset = new ArrayList<Movie>();
    private Context mContext;
    private String TAG = "MyAdaptor";
    private int lastPosition = -1;



    private final Movie mLock = new Movie();


    public static class ViewHolder extends RecyclerView.ViewHolder {
//        private final TextView textView;
        private final ImageView imageView;
        private final FrameLayout container;



        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.

//            textView = (TextView) v.findViewById(R.id.info_text);
            imageView = (ImageView) v.findViewById(R.id.image);
            container = (FrameLayout) itemView.findViewById(R.id.card_view);



        }

//        public TextView getTextView() {
//            return textView;
//        }
    }

    public MovieAdaptor(List<Movie> myDataset,Context ct) {
        mDataset = myDataset;
        mContext =ct;

    }

    public void setData(List<Movie> data) {
        clear();
        for (Movie movie : data) {
            add(movie);
        }
    }

    public void add(Movie object) {
        synchronized (mLock) {
            if(mDataset==null){}else {
                mDataset.add(object);
            }
        }

        Log.e(TAG,"notifyDataSetChanged  add");

        notifyDataSetChanged();

    }


    public void clear() {
        synchronized (mLock) {

            if(mDataset == null){

            }else{
                mDataset.clear();
            }

        }
        Log.e(TAG,"notifyDataSetChanged");

        notifyDataSetChanged();
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String image_url = "http://image.tmdb.org/t/p/w185" + mDataset.get(position).getPosterPath();
        Log.e(TAG, image_url);
        Picasso.with(mContext).load(image_url).into(holder.imageView, PicassoPalette.with(image_url, holder.imageView)
                                                                                    .use(PicassoPalette.Profile.MUTED_DARK)
                                                   );
//        holder.textView.setText(mDataset.get(position).getOriginalTitle());
        // Removed animat
//        setAnimation(holder.container, position);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"overv "+mDataset.get(position).getOverview());
                Intent i = new Intent(mContext, DetailActivity.class);
                i.putExtra("movie", mDataset.get(position));
                mContext.startActivity(i);

            }
        });



    }

    private void setAnimation(View viewToAnimate, int position)
    {
         if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.fade_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
         return mDataset == null ? 0 : mDataset.size();
    }

    @Override
    public MovieAdaptor.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
}
