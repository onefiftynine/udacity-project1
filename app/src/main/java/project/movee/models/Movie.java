package project.movee.models;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nickyg on 30/03/16.
 */
public class Movie  implements Parcelable{

//    {
//        "adult": false,
//            "backdrop_path": "/dkMD5qlogeRMiEixC4YNPUvax2T.jpg",
//            "genre_ids": [
//        28,
//                12,
//                878,
//                53
//        ],
//        "id": 135397,
//            "original_language": "en",
//            "original_title": "Jurassic World",
//            "overview": "Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.",
//            "release_date": "2015-06-12",
//            "poster_path": "/uXZYawqUsChGSj54wcuBtEdUJbh.jpg",
//            "popularity": 88.551849,
//            "title": "Jurassic World",
//            "video": false,
//            "vote_average": 7.1,
//            "vote_count": 435
//    },

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }

        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }
    };
        @Override
    public void writeToParcel(Parcel dest, int flags) {

            dest.writeInt(id);
            dest.writeString(originalTitle);
            dest.writeString(posterPath);
            dest.writeString(overview);
            dest.writeString(voteAverage);
            dest.writeString(releaseDate);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    private String originalTitle;
    private String overview;
    private String posterPath;
    private String voteAverage;
    private String releaseDate;

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Movie(){

    }


    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Movie(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.originalTitle = movie.getString("original_title");
        this.posterPath = movie.getString("poster_path");

//        this.image2 = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.voteAverage = movie.getString("vote_average");
        this.releaseDate = movie.getString("release_date");
//        this.id = movie.getString("overview");
//        this.rating = movie.getInt("vote_average");
//        this.date = movie.getString("release_date");
    }

    public Movie(Parcel parcel){
        this.id = parcel.readInt();
        this.originalTitle = parcel.readString();
        this.posterPath  = parcel.readString();
        this.overview = parcel.readString();
        this.voteAverage = parcel.readString();
        this.releaseDate = parcel.readString();
    }
}
