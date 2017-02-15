package com.download.downloadmanagers.sysdownload;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.download.downloadmanagers.R;

public class SysDownLoadActivity extends Activity implements View.OnClickListener {

    private View mStartDownload;
    private View mStopDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_down_load);
        mStartDownload = findViewById(R.id.start_download);
        mStopDownload = findViewById(R.id.stop_download);
        mStartDownload.setOnClickListener(this);
        mStopDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        switch (id) {
            case R.id.start_download:
                startDownload();
                break;
            case R.id.stop_download:
                break;
        }
    }

    private void startDownload() {
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

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d("Test", "onWindowFocusChanged2 hasFocus: " + hasFocus);
    }
}
