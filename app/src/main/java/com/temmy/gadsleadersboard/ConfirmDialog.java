package com.temmy.gadsleadersboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmDialog extends DialogFragment {
    String email, surname, firstName, git;

    public ConfirmDialog(String email, String surname, String firstName, String git) {
        this.email = email;
        this.surname = surname;
        this.firstName = firstName;
        this.git = git;
    }

    Button button;
    ImageView image;
    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.confirmation_dialog, container, false);
        button = mView.findViewById(R.id.confirm);
        image = mView.findViewById(R.id.cancel);
        View.OnClickListener listener = view -> cancel();
        image.setOnClickListener(listener);

        View.OnClickListener ConfirmListener = view -> sendData();
        button.setOnClickListener(ConfirmListener);
        return mView ;
    }


    public void cancel() {
        getDialog().cancel();
    }

    public void sendData(){
        Call<Void> call = RetrofitClient.getInstance().getApi().sendData(firstName, surname, email, git);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                getDialog().cancel();
                SuccessDialog mdialog = new SuccessDialog();
                mdialog.show(getFragmentManager(),  "success");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                getDialog().cancel();
                FailureDialog mdialog = new FailureDialog();
                mdialog.show(getFragmentManager(), "failure");
            }
        });

    }

}
