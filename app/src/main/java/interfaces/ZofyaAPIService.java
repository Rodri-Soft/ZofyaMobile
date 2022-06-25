package interfaces;

import com.google.gson.JsonArray;

import classes.ZofyaFetchResults;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ZofyaAPIService {

    @GET("/Items/Woman/Blouses")
    Call<ZofyaFetchResults> getItem();

}