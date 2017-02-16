package lipan.com.pasieniatask;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

import static android.R.attr.password;


/**
 * Created by adibta on 2/11/2017.
 */

public class RegisterFragment extends Fragment {

    private EditText namaEditText, emailEditText, passwordEditText, passwordLagiEditText;
    private final static String CONTEXT_KEY = "kunci dari konteks";

    public static RegisterFragment newInstance() {
        RegisterFragment fragmentPager = new RegisterFragment();
        return fragmentPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_daftar, container, false);
        namaEditText = (EditText) viewRoot.findViewById(R.id.daftar_nama);
        emailEditText = (EditText) viewRoot.findViewById(R.id.daftar_email);
        passwordEditText = (EditText) viewRoot.findViewById(R.id.daftar_password);
        passwordLagiEditText = (EditText) viewRoot.findViewById(R.id.daftar_password_lagi);

    return viewRoot;
    }
}
