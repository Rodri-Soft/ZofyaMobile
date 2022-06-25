package classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ZofyaFetchResults {
    /*
    @SerializedName("results")
    @Expose*/


    private ArrayList<Item> results;

    public ArrayList<Item> getResults() {
        return results;
    }

    public void setResults(ArrayList<Item> results) {
        this.results = results;
    }
}
