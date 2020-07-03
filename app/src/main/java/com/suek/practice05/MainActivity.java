package com.suek.practice05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    SearchView searchView;

    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    ViewPager pager;
    TabAdapter adapter;

    ArrayList<Item> items= new ArrayList<>();
    ItemAdapter itemAdapter;
    RecyclerView recyclerView;

    ArrayList<Best_Item> best_items= new ArrayList<>();
    BestItemAdapter bestItemAdapter;
    RecyclerView recyclerview_BestItem;

    LikeButton likeButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setSubtitle("먹자타운 레시피");


        tabLayout= findViewById(R.id.tabLayout);

        adapter= new TabAdapter(getSupportFragmentManager());
        pager= findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        drawerLayout= findViewById(R.id.drawerLayout);
        navigationView= findViewById(R.id.nav);
        actionBarDrawerToggle= new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setTitle("Mukja Town");




        best_items.add(new Best_Item("https://img.maisonkorea.com/2018/07/msk_5b42bffc31bcb-1024x683.jpg", "주방도구세트", "99,000원"));
        best_items.add(new Best_Item("https://cdnimage.ebn.co.kr/news/201801/news_1516663921_926803_main1.jpg", "냄비세트", "250,000원"));
        best_items.add(new Best_Item("https://image.yes24.com/momo/TopCate2644/MidCate4/264331611.jpg", "독일 칼세트", "120,000원"));
        best_items.add(new Best_Item("https://img.maisonkorea.com/2018/07/msk_5b42bffc31bcb-1024x683.jpg", "주방도구세트", "99,000원"));
        best_items.add(new Best_Item("https://cdnimage.ebn.co.kr/news/201801/news_1516663921_926803_main1.jpg", "냄비세트", "250,000원"));
        best_items.add(new Best_Item("https://image.yes24.com/momo/TopCate2644/MidCate4/264331611.jpg", "독일 칼세트", "120,000원"));
        best_items.add(new Best_Item("https://img.maisonkorea.com/2018/07/msk_5b42bffc31bcb-1024x683.jpg", "주방도구세트", "99,000원"));
        best_items.add(new Best_Item("https://cdnimage.ebn.co.kr/news/201801/news_1516663921_926803_main1.jpg", "냄비세트", "250,000원"));
        best_items.add(new Best_Item("https://image.yes24.com/momo/TopCate2644/MidCate4/264331611.jpg", "독일 칼세트", "120,000원"));

        bestItemAdapter= new BestItemAdapter(this, best_items);
        recyclerview_BestItem= findViewById(R.id.recycler_bestItem);
        recyclerview_BestItem.setAdapter(bestItemAdapter);





        items.add(new Item("https://www.skinnytaste.com/wp-content/uploads/2010/02/Roast-Chicken-with-Rosemary-_-Lemon-Finals-15.jpg", "로스트 치킨", "백종원님의 레시피"));
        items.add(new Item("https://simply-delicious-food.com/wp-content/uploads/2018/11/spicy-chicken-burgers-3.jpg", "비프버거", "김수미님의 레시피"));
        items.add(new Item("https://smilesandwich.com/wp-content/uploads/2019/09/Seafood-Pasta-with-Roasted-Veggies-3-735x945.jpg", "해물 파스타", "김유민님의 레시피"));
        items.add(new Item("https://healthyfitnessmeals.com/wp-content/uploads/2018/06/instagram-In-Stream_Square___protein-waffles-3.jpg", "블루베리 와플", "김보름님의 레시피"));
        items.add(new Item("https://vistapointe.net/images/stake-12.jpg", "와규", "15,000원"));
        items.add(new Item("https://createmindfully.com/wp-content/uploads/2016/08/vegan-hawaiian-bbq-pizza-in-pan.jpg", "하와이언 비비큐 피자", "김효연님의 레시피"));
        items.add(new Item("https://img.etoday.co.kr/pto_db/2019/07/600/20190726153503_1350707_1200_876.jpg", "불고기 비빔밥", "알렉스님의 레시피"));
        items.add(new Item("https://www.skinnytaste.com/wp-content/uploads/2010/02/Roast-Chicken-with-Rosemary-_-Lemon-Finals-15.jpg", "로스트 치킨", "김혜원님의 레시피"));
        items.add(new Item("https://simply-delicious-food.com/wp-content/uploads/2018/11/spicy-chicken-burgers-3.jpg", "비프버거", "제시님의 레시피"));
        items.add(new Item("https://smilesandwich.com/wp-content/uploads/2019/09/Seafood-Pasta-with-Roasted-Veggies-3-735x945.jpg", "해물 파스타", "김미수님의 레시피"));
        items.add(new Item("https://healthyfitnessmeals.com/wp-content/uploads/2018/06/instagram-In-Stream_Square___protein-waffles-3.jpg", "블루베리 와플", "박혜령님의 레시피"));
        items.add(new Item("https://vistapointe.net/images/stake-12.jpg", "와규", "15,000원"));
        items.add(new Item("https://createmindfully.com/wp-content/uploads/2016/08/vegan-hawaiian-bbq-pizza-in-pan.jpg", "하와이언 비비큐 피자", "김지훈님의 레시피"));
        items.add(new Item("https://img.etoday.co.kr/pto_db/2019/07/600/20190726153503_1350707_1200_876.jpg", "불고기 비빔밥", "례원님의 레시피"));

        itemAdapter= new ItemAdapter(this, items);
        recyclerView= findViewById(R.id.recycler);
        recyclerView.setAdapter(itemAdapter);




        likeButton= findViewById(R.id.likeButton);
        /*likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

            }

            @Override
            public void unLiked(LikeButton likeButton) {

            }
        });*/





        //BottomNavigation 클릭하면 실행되는 메소드
        bottomNavigationView= findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.home:
                        Intent intent= new Intent(MainActivity.this, MainActivity.class);  //그냥 메인화면으로 설정하고싶을때?
                        startActivity(intent);
                        break;
                    case R.id.shopping:
                        Intent intent1= new Intent(MainActivity.this, MyBlogActivity.class );
                        startActivity(intent1);
                        break;
                    case R.id.script:
                        Intent intent2= new Intent(MainActivity.this, ScriptActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.notification:
                        Intent intent3= new Intent(MainActivity.this, FifthActivity.class);    ////// 소리 //////
                        startActivity(intent3);
                        break;
                    case R.id.event:
                        Intent intent4= new Intent(MainActivity.this, SixthActivity.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });


        }//onCreate



    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.actionbar, menu);
        MenuItem item= menu.findItem(R.id.menu_search);
        searchView= (SearchView) item.getActionView();
        searchView.setQueryHint("입력하세요");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "검색", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }*/
}//MainActivity





