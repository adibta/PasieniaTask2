package lipan.com.pasieniatask;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by adibta on 2/14/2017.
 */

public class SlideShowFragment extends Fragment {

    private static final String EXTRA_MESSAGE_IMG_RESOURCE = "Img Resource Ekstra message";
    private static final String EXTRA_MESSAGE_HEADING ="Heading Ekstra message";
    private static final String EXTRA_MESSAGE_CONTENT ="Content Ekstra message";

    public static SlideShowFragment newInstance(int imgResource, String heading, String content){

        SlideShowFragment fragmentPager= new SlideShowFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_MESSAGE_IMG_RESOURCE,imgResource);
        bundle.putString(EXTRA_MESSAGE_HEADING,heading);
        bundle.putString(EXTRA_MESSAGE_CONTENT,content);

        fragmentPager.setArguments(bundle);

        return fragmentPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewRoot = inflater.inflate(R.layout.fragment_slide_show,container,false);

        TextView tvHeading = (TextView) viewRoot.findViewById(R.id.heading_slide_show);
        TextView tvContent = (TextView) viewRoot.findViewById(R.id.content_slide_show);
        ImageView img = (ImageView) viewRoot.findViewById(R.id.image_slide_show);

        String heading = getArguments().getString(EXTRA_MESSAGE_HEADING);
        String content = getArguments().getString(EXTRA_MESSAGE_CONTENT);
        int imgResource = getArguments().getInt(EXTRA_MESSAGE_IMG_RESOURCE);

        tvHeading.setText(heading);
        tvContent.setText(content);
        img.setImageResource(imgResource);

        return viewRoot;
    }
}
