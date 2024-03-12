package com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.constiutionofindia.R;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int image[] = {
            R.drawable.imge1,
            R.drawable.imge2,
            R.drawable.imge3
    };

    int heading[] = {
           R.string.heading_one,
            R.string.heading_two,
            R.string.heading_three
    };

    int description[] = {

            R.string.desc_one,
            R.string.desc_two,
            R.string.desc_three

    };

    public ViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout)object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);

        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImage);
        TextView sliderHeading = (TextView) view.findViewById(R.id.texttitle);
        TextView slideDescription = (TextView) view.findViewById(R.id.textdeccription);

        slidetitleimage.setImageResource(image[position]);
        sliderHeading.setText(heading[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object){

        container.removeView((LinearLayout)object);
    }
}
