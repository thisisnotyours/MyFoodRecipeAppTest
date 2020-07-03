package com.suek.practice05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeThumbnailView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class YoutubeActivity extends AppCompatActivity {

    YouTubePlayerFragment youTubePlayerFragment;
    YouTubeThumbnailView youTubeThumbnailView;
    EditText et;
    TextView tv;

    String[] youtubeDatas= new String[]{"KX-EC_M2CKE", "N2MjPAp1vKk", "ECl4dA5M5Ds", "UGJmY8cNd5g","thkD_x6_eaM", "6IsBtZH4x40", "wRUGA314ey0",
                                        "KX-EC_M2CKE", "N2MjPAp1vKk", "ECl4dA5M5Ds", "UGJmY8cNd5g","thkD_x6_eaM", "6IsBtZH4x40", "wRUGA314ey0" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        Intent intent= getIntent();
        int pos= intent.getIntExtra("pos", -1);
        if(pos == -1){
            Toast.makeText(this, "로드실패", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, pos+"", Toast.LENGTH_SHORT).show();


        youTubePlayerFragment= (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_fragment);
        youTubePlayerFragment.initialize("first", new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(youtubeDatas[pos]); //비디오아이디  //https://www.youtube.com/watch?v=KX-EC_M2CKE
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(YoutubeActivity.this, "비디오 로드실패", Toast.LENGTH_SHORT).show();
            }
        });




        /*youTubeThumbnailView= findViewById(R.id.thumnailview);
        youTubeThumbnailView.initialize("second", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {
                youTubeThumbnailLoader.setVideo("KX-EC_M2CKE");   //유튜브 썸네일 이미지
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });*/






    }

    //Youtube Data API 사용
    // 검색기능 API 는 REST 방식으로 데이터(json)를 제공
    // GET https://www.googleapis.com/youtube/v3/search
    //요청 파라미터 : key(필수), part(필수), q(검색어), maxResults(결과개수: 0~50개)

    public void clickBtn(View view) {
        et= findViewById(R.id.et);
        tv= findViewById(R.id.tv);

        String key= "AIzaSyAhg2AjdIlR7s_9hRIrvwzLC0TGEjk9iuw";
        String part= "snippet";
        String query= et.getText().toString();
        int maxResults= 10;


        //Retrofit 을 쓰되- 결과를 우선은 String 으로 받기 --> 연습할때는 json 으로..
        Retrofit retrofit= RetrofitHelper.getInstance();
        RetrofitService retrofitService= retrofit.create(RetrofitService.class);

        Call<String> call= retrofitService.searchVideos(key, part, query, maxResults);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String data= response.body();
                tv.setText(data);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
}
