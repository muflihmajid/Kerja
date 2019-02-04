package abadi.sejahtera.pt.ajobthing.API;

import java.util.List;

import abadi.sejahtera.pt.ajobthing.Data.jobs;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIALL {
    String BASE_URL = "https://private-fa7449-testjobs.apiary-mock.com/api/";

    @GET("recommendation")
    Call<List<jobs>> getJobs();
}
