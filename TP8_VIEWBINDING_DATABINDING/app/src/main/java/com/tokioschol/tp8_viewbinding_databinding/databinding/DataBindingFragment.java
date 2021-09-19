package com.tokioschol.tp8_viewbinding_databinding.databinding;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;

import com.tokioschol.tp8_viewbinding_databinding.R;
import com.tokioschol.tp8_viewbinding_databinding.databinding.domain.CivilStatus;
import com.tokioschol.tp8_viewbinding_databinding.databinding.domain.Gender;
import com.tokioschol.tp8_viewbinding_databinding.databinding.domain.UserModel;

public class DataBindingFragment extends Fragment {

    private FragmentDatabindingInflateBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Crear la vista del Fragment
        binding = FragmentDatabindingInflateBinding.inflate(inflater, container, false);
        //Set data al layout-objeto binding-
        binding.setUser(provideUser());
        return binding.getRoot();

    }

    @BindingAdapter(value = {"app:colorView","app:srcVectorDrawable"},requireAll = true)
    public static void setSrcVector(AppCompatImageView view, @ColorRes int color, Drawable resource){
        if(view!=null){
            view.setImageDrawable(resource);
            view.setColorFilter(color);
        }
    }

    private UserModel provideUser() {
        UserModel userModel = new UserModel();
        userModel.setAge(25);
        //userModel.setName("manel");
        userModel.setLastName("cabezas");
        userModel.setGender(Gender.MALE);
        userModel.setCivilState(CivilStatus.MARRIED);
        return userModel;
    }
}
