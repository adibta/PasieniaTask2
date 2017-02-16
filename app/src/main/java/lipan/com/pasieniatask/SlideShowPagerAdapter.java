package lipan.com.pasieniatask;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import static android.nfc.tech.MifareUltralight.PAGE_SIZE;

/**
 * Created by adibta on 2/14/2017.
 */

public class SlideShowPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> heading, content;
    private ArrayList<Integer> imgResource;
    private int pageSize;

    public SlideShowPagerAdapter(FragmentManager fragmentManager, ArrayList<Integer> imgResource, ArrayList<String> heading, ArrayList<String> content, int pageSize)
    {
        super(fragmentManager);
        this.imgResource = imgResource;
        this.heading = heading;
        this.content = content;
        this.pageSize = pageSize;
    }

    @Override
    public Fragment getItem(int position) {
        return SlideShowFragment.newInstance(imgResource.get(position),heading.get(position),content.get(position));
    }

    @Override
    public int getCount() {
        return pageSize;
    }
}
