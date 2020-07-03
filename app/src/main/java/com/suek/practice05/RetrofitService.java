package com.suek.practice05;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/youtube/v3/search")
    Call<String> searchVideos(@Query("key") String key,
                              @Query("part") String part,
                              @Query("q") String q,
                              @Query("maxResults") int maxResults);
}
