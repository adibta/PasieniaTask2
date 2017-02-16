package lipan.com.pasieniatask;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by adibta on 2/11/2017.
 */

public class LoginFragment extends Fragment{
    private ImageButton facebookButton, googleButton;
    private EditText emailEditText, passwordEditText;
    private TextView lupaPasswordTextView;

    public static LoginFragment newInstance(){
        LoginFragment fragmentPager= new LoginFragment();
        return fragmentPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_login,container,false);
        emailEditText = (EditText) viewRoot.findViewById(R.id.login_email);
        passwordEditText = (EditText) viewRoot.findViewById(R.id.login_password);
        lupaPasswordTextView = (TextView)viewRoot.findViewById(R.id.login_lupa_password);
        facebookButton = (ImageButton) viewRoot.findViewById(R.id.login_facebook_button);
        googleButton = (ImageButton) viewRoot.findViewById(R.id.login_google_button);

        return viewRoot;
    }
}
