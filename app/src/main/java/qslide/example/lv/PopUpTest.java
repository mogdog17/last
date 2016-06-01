package qslide.example.lv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;

public class PopUpTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_test);
    }
    final PopupMenu popup = new PopupMenu(MainActivity.this,);
//Inflating the Popup using xml file
    popup.
            getMenuInflater().inflate(R.menu.plus_popup_menu, popup.getMenu());

    //registering popup with OnMenuItemClickListener
    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            synchronized (locker) {
                switch (item.getItemId()) {
                    case (R.id.camera_source):
                        mSurfaceComponents.add(new SurfaceComponent(CameraSource, new Position()));
                        //paint.setColor(Color.GREEN);
                        //canvas.drawRect(20F, 300F, 180F, 400F, paint); // left top right bottom
                        //mImageView.invalidate();
                        //mImageView.refreshDrawableState();
                        break;
                    case (R.id.image_source):
                        loadImageFromGallery();
                        break;
                    case (R.id.text_source):
                        String text = "Test Text Source";
                        Position pos = new Position(20, 500, 180, 400);
                        ImageSource textSource = new TextSource(text, pos);
                        mSurfaceComponents.add(new SurfaceComponent(textSource, pos));
                        break;
                    case (R.id.screen_source):
                        SurfaceComponent screenComponent = new SurfaceComponent(new ScreenSource(), new Position());
                        //screenComponent.Enable();
                        mSurfaceComponents.add(screenComponent);
                        break;
                }
                //popup.dismiss();
                SCadapter.swap((ArrayList<SurfaceComponent>) mSurfaceComponents.clone());
                refreshSurfaceComponentsOnBitmap();
                return true;
            }
        }
    });
    popup.show();//showing popup menu

}







