package com.example.ndkstorages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "MainActivity";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nativeLibraryDir = getApplicationInfo().nativeLibraryDir;
        String internalStoragePath = getFilesDir().getPath();
        String externalStoragePath = getExternalFilesDir(null).getPath();

        Log.d(TAG, "nativeLibraryDir: " + nativeLibraryDir);
        Log.d(TAG, "internalStoragePath: " + internalStoragePath);
        Log.d(TAG, "externalStoragePath: " + externalStoragePath);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}