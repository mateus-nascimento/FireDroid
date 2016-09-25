package ledare.com.br.firedroid.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by mateus on 19/09/2016.
 */
public class ImageBinding {
    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
