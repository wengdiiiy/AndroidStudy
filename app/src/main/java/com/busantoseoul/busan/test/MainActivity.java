package com.busantoseoul.busan.test;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.busantoseoul.busan.FragmentTabBoard;
import com.busantoseoul.busan.FragmentTabNaverCafe;
import com.busantoseoul.busan.FragmentTabNotice;
import com.busantoseoul.busan.R;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    final String TAG = "MainActivity";

    int mCurrentFragmentIndex;
    public final static int FRAGMENT_ONE = 0;
    public final static int FRAGMENT_TWO = 1;
    public final static int FRAGMENT_THREE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button bt_oneFragment = (Button) findViewById(R.id.bt_oneFragment);
        bt_oneFragment.setOnClickListener(this);
        Button bt_twoFragment = (Button) findViewById(R.id.bt_twoFragment);
        bt_twoFragment.setOnClickListener(this);
        Button bt_threeFragment = (Button) findViewById(R.id.bt_threeFragment);
        bt_threeFragment.setOnClickListener(this);

        mCurrentFragmentIndex = FRAGMENT_ONE;

        fragmentReplace(mCurrentFragmentIndex);
    }

    public void fragmentReplace(int reqNewFragmentIndex) {
        Fragment newFragment = null;

        newFragment = getFragment(reqNewFragmentIndex);

        final FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.ll_fragment, newFragment);

        // Commit the transaction
        transaction.commit();

    }

    private Fragment getFragment(int idx) {
        Fragment newFragment = null;

        switch (idx) {
            case FRAGMENT_ONE:
                newFragment = new FragmentTabBoard();
                break;
            case FRAGMENT_TWO:
                newFragment = new FragmentTabNaverCafe();
                break;
            case FRAGMENT_THREE:
                newFragment = new FragmentTabNotice();
                break;

            default:
                Log.d(TAG, "Unhandle case");
                break;
        }

        return newFragment;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_oneFragment:
                mCurrentFragmentIndex = FRAGMENT_ONE;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.bt_twoFragment:
                mCurrentFragmentIndex = FRAGMENT_TWO;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.bt_threeFragment:
                mCurrentFragmentIndex = FRAGMENT_THREE;
                fragmentReplace(mCurrentFragmentIndex);
                break;

        }

    }

}