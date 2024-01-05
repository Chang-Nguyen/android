package com.trangduc.fatbooks.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.trangduc.fatbooks.R;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonLogin = view.findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                // Thực hiện xử lý đăng nhập ở đây
                if (performLogin(username, password)) {
                    // Đăng nhập thành công, thực hiện chuyển đến màn hình chính
                    Toast.makeText(getActivity(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    switchToHomeFragment();
                } else {
                    Toast.makeText(getActivity(), "Đăng nhập thất bại. Vui lòng thử lại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private boolean performLogin(String username, String password) {
        // Thực hiện xử lý đăng nhập ở đây
        // Trả về true nếu đăng nhập thành công, ngược lại trả về false
        // Đây chỉ là ví dụ đơn giản, bạn cần thay thế bằng logic xử lý thực tế
        return username.equals("admin") && password.equals("123456");
    }

    private void switchToHomeFragment() {
        // Thực hiện chuyển sang màn hình chính
        // Tương tự như switchToLoginFragment trong LoginRequiredFragment
    }
}
