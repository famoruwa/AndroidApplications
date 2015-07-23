package com.example.felixamoruwa.greenday;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class ImageAdapter extends BaseAdapter {

    int mGalleryItemBackground;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView i = new ImageView(mContext);

        i.setImageResource(mImageIds[position]);
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        i.setLayoutParams(new Gallery.LayoutParams(136, 88));

        return i;
    }

    private Context mContext;

    private Integer[] mImageIds = {
            R.drawable.greenday1,
            R.drawable.greenday2,
            R.drawable.greenday3,
            R.drawable.greenday4,
            R.drawable.greenday5
    };
}

