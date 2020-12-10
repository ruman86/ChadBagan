package club.innovinc.bagan;

import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
public class WebViewActivity extends AppCompatActivity {

    WebView productWebView;
    String productId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_web_view);

        productId = getIntent().getStringExtra("productid");
        productWebView =  findViewById(R.id.productWebView);

        WebSettings webSettings = productWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        productWebView.loadUrl("https://adsolutoins.company.site/");
    }
}