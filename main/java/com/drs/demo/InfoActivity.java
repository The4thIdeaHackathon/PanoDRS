package com.drs.demo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Info Activity
 * 개발자 정보 및 공지사항 적어두는 액티비티
 */

public class InfoActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    /**레이아웃 구성요소**/
    private Button mBtnHelp;
    private Button mBtnNotice;
    private Button mBtnInfo;

    /**BottomNavigationView 구성요소 및 리스너**/
    private BottomNavigationView mNavigationView;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                startActivity( new Intent(InfoActivity.this, ConnectionActivity.class));
                finish();
                return true;
            case R.id.action_image:
                startActivity( new Intent(InfoActivity.this, ImageActivity.class));
                finish();
                return true;
            case R.id.action_info:
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initUI();
    }

    /**
     * 레이아웃의 점검 이후 id에 따라 추가해야함
     * 기능 테스트시, enabled의 주석처리이후 체크(드론 가지고있지 않을 때)
     */
    private void initUI() {

        mBtnHelp = (Button)findViewById(R.id.btn_help);
        mBtnHelp.setOnClickListener(this);

        mBtnNotice = (Button)findViewById(R.id.btn_notice);
        mBtnNotice.setOnClickListener(this);

        mBtnInfo = (Button)findViewById(R.id.btn_info);
        mBtnInfo.setOnClickListener(this);

        //BottomNavigationView Listener
        mNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        mNavigationView.setOnNavigationItemSelectedListener(this);
        mNavigationView.setSelectedItemId(R.id.action_info);


    }

    /**
     * String --> Toast 변환 메소드
     */
    public void showToast(final String msg) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(InfoActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_notice: {
                Uri uri = Uri.parse("https://junja1997.wixsite.com/panodrsnotice");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
            }
            case R.id.btn_info: {
                Intent intent = new Intent(this, InfobtnActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_help: {
                Intent intent = new Intent(this, HelpActivity.class);
                startActivity(intent);
                break;
            }

            default:
                break;
        }
    }

}
