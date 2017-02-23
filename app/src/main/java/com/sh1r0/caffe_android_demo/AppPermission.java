package com.sh1r0.caffe_android_demo;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.widget.Toast;

/**
 * Created by yamatchan on 17/2/22.
 */

public class AppPermission {
    public static final int REQUEST_PERMISSION = 10;
    private final MainActivity mActivity;

    public AppPermission(MainActivity activity) {
        mActivity = activity;
    }

    public void checkReadExternalStorage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isGrantedReadExternalStorage()) {
                if (mActivity != null) mActivity.initialize();
            } else {
                requestReadExternalStoragePermission();
            }
        } else {
            if (mActivity != null) mActivity.initialize();
        }
    }

    public boolean checkCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (isCamera()) {
                return true;
            } else {
                requestCameraPermission();
                return false;
            }
        } else {
            return true;
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean isGrantedReadExternalStorage() {
        return mActivity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private boolean isCamera() {
        return mActivity.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestReadExternalStoragePermission() {
        if (mActivity.shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Toast toast = Toast.makeText(mActivity, "You need to permit reading external storage", Toast.LENGTH_SHORT);
            toast.show();
        }
        mActivity.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestCameraPermission() {
        if (mActivity.shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
            Toast toast = Toast.makeText(mActivity, "You need to permit using camera", Toast.LENGTH_SHORT);
            toast.show();
        }
        mActivity.requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION);
    }
}
