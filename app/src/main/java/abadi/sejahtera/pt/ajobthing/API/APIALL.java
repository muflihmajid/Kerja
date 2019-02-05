package abadi.sejahtera.pt.ajobthing.API;

import java.util.List;

import abadi.sejahtera.pt.ajobthing.Data.data;
import abadi.sejahtera.pt.ajobthing.Data.jobs;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIALL {
    String BASE_URL = "http://private-anon-4ccc28af0b-testjobs.apiary-mock.com/api/";

    @GET("recommendation")
    Call<jobs> data();
}
