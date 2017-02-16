package lipan.com.pasieniatask;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by adibta on 2/11/2017.
 */

public class LoginRegisterPagerAdapter extends FragmentPagerAdapter {

    public LoginRegisterPagerAdapter(FragmentManager fragmentManager){

        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LoginFragment.newInstance();
            default:
                return RegisterFragment.newInstance();
        }
    }

    @Override
    public int getCount() {

        return 2;
    }

}