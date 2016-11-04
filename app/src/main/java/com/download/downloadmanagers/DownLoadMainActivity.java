package com.download.downloadmanagers;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import static android.os.Build.VERSION.SDK;

public class DownLoadMainActivity extends Activity implements View.OnClickListener {

    private View mSysDownloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_main);
        mSysDownloadBtn = (Button) findViewById(R.id.sys_download);
        mSysDownloadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse("https://downpack.baidu.com/baidusearch_AndroidPhone_1019109d.apk");
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("下载APK");
        request.setDescription("手机百度");
        if (Build.VERSION.SDK_INT >= 11) {
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        }
        long taskId = downloadManager.enqueue(request);
        Log.d("Download", "TaskId: " + taskId);
    }
}
