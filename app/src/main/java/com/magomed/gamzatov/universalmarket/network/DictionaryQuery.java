package com.magomed.gamzatov.universalmarket.network;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by MacBookAir on 23.02.17.
 */

public interface DictionaryQuery {

    @GET(ServiceGenerator.API_PREFIX_URL+ "/dictionaries/{type}")
    Call<List<Map<String, String>>> getDictionaries(@Path("type") String type);

}
