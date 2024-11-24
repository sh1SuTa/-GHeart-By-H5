package top.putileaf.gheartsbyh5;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取 WebView
        WebView webView = findViewById(R.id.webView);

        // 设置 WebSettings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  // 启用 JavaScript
        webSettings.setDomStorageEnabled(true);  // 启用 DOM 存储
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);  // 设置缓存模式

        // 支持混合内容（加载 HTTP 和 HTTPS 内容）
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }

        // 加载网址
        webView.loadUrl("http://xin.putileaf.top/");

        // 设置 WebViewClient 以防止跳转到外部浏览器
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, android.webkit.WebResourceError error) {
                super.onReceivedError(view, request, error);
                // 处理加载错误
            }
        });

        // 设置 WebChromeClient 以便处理页面加载进度等
        webView.setWebChromeClient(new WebChromeClient());

        // 设置 Edge-to-Edge 和 Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
