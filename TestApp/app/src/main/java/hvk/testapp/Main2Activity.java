package hvk.testapp;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;

//import tensorflow.tensorflow.examples.android.src.org.tensorflow.demo;

public class Main2Activity extends AppCompatActivity implements TextureView.SurfaceTextureListener {
    MediaPlayer m;
    TextureView textureView;
    private String streamURL = "rtsp://192.168.240.1:5544/ph";
    private Uri streamURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        streamURL = getIntent().getStringExtra(URL);
        streamURI = Uri.parse(streamURL);
        setContentView(R.layout.activity_main2);

        initView();
    }

    private void initView() {
        textureView = (TextureView) findViewById(R.id.potato);
        textureView.setSurfaceTextureListener(this);
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        Surface s = new Surface(surfaceTexture);
        try
        {
            m = new MediaPlayer();
            streamURI = Uri.parse(streamURL);
            m.setDataSource(getApplicationContext(), streamURI);
            m.setSurface(s);
            m.prepareAsync();
            m.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Bitmap b = textureView.getBitmap();
//        FINALLY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        ImageView imgView = (ImageView)findViewById(R.id.tomato);
        imgView.setImageBitmap(b);
    }
}
