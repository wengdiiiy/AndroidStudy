package com.busantoseoul.busan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FragmentTabNaverCafe extends Fragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragment2.
     */

    private WebView webview;
    public static FragmentTabNaverCafe newInstance() {
        return new FragmentTabNaverCafe();
    }

    public FragmentTabNaverCafe() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_navercafe, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        webview = (WebView) getActivity().findViewById(R.id.webview);
        WebSettings setting = webview.getSettings();

        if (savedInstanceState == null) {
            webview.loadUrl("http:\\www.naver.com");
            setting.setJavaScriptEnabled(true);
        } else {
            webview.restoreState(savedInstanceState);
        }

        webview.setWebViewClient(new webViewClient());

        webview.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                //This is the filter
                if (event.getAction()!=KeyEvent.ACTION_DOWN)
                    return true;

                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    if (webview.canGoBack()) {
                        webview.goBack();
                    } else {
                        getActivity().onKeyDown(keyCode,event);
                    }

                    return true;
                }
                return false;
            }
        });
    }
}

class webViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}