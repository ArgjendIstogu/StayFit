package fiek.unipr.stayfit.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import fiek.unipr.stayfit.R;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private int[] imageId = new int[] {R.drawable.five,R.drawable.first,R.drawable.second,R.drawable.third,R.drawable.five};

    public ImageAdapter (Context context){
        mContext = context;

    }

    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(imageId[position]);
        container.addView(imageView,0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull  ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
