package com.suek.practice05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ScriptActivity extends AppCompatActivity {

    ArrayList<FoodItem> foodItems= new ArrayList<>();
    RecyclerView recyclerView;
    FoodItemAdapter foodItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_script);


        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));
        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));
        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));
        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));
        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));
        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));
        foodItems.add(new FoodItem("닭볶음탕","백종원님의 레시피 보기", R.drawable.back, "https://recipe1.ezmember.co.kr/cache/recipe/2017/09/12/8a64e811117ac8b1481ee52bd443b85c1.jpg"));
        foodItems.add(new FoodItem("오이무침", "김수미님 레시피 보기",R.drawable.sumi , "https://i.pinimg.com/originals/5d/c9/5d/5dc95dcb313d83a674e522d621de5900.jpg"));

        foodItemAdapter= new FoodItemAdapter(this, foodItems);
        recyclerView= findViewById(R.id.recycler);
        recyclerView.setAdapter(foodItemAdapter);
    }
}
