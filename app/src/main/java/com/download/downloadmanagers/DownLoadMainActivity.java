package com.download.downloadmanagers;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.download.downloadmanagers.sysdownload.SysDownLoadActivity;

import static android.os.Build.VERSION.SDK;

public class DownLoadMainActivity extends Activity implements View.OnClickListener {

    private Button mSysDownloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_main);
        mSysDownloadBtn = (Button) findViewById(R.id.sys_download);
        mSysDownloadBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.sys_download:
                Intent intent = new Intent(DownLoadMainActivity.this, SysDownLoadActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
