package club.innovinc.bagan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String cate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void categoryClickid(View view) {
        switch(view.getId()){
            case R.id.idchasabad:
                cate = "101";
                switchToIntent(cate);
                break;
            case R.id.idtimeday:
                cate = "102";
                switchToIntent(cate);
                break;
            case R.id.idbiz:
                cate = "103";
                switchToIntentProduct(cate);
                break;
            case R.id.idsar:
                cate = "104";
                switchToIntent(cate);
                break;
            case R.id.idbalainasok:
                cate = "105";
                switchToIntent(cate);
                break;
            case R.id.iddiscussion:
                cate = "106";
                switchToIntent(cate);
                break;
        }
    }

    void switchToIntent(String cate){
        Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
        intent.putExtra("cate", cate);
        startActivity(intent);
    }

    void switchToIntentProduct(String cate){
        Intent intent = new Intent(MainActivity.this, PrductListActivity.class);
        intent.putExtra("cate", cate);
        startActivity(intent);
    }
}