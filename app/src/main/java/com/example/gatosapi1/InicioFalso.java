package com.example.gatosapi1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFalso#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFalso extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InicioFalso() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFalso.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFalso newInstance(String param1, String param2) {
        InicioFalso fragment = new InicioFalso();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args=getArguments();

        ImageView logo=view.findViewById(R.id.imagenLogo);
        logo.setImageResource(R.drawable.gato);

        ImageView gatoHist=view.findViewById(R.id.ImagenFalsa);
        Picasso.get().load(args.getString("ImagenGato")).into(gatoHist);

        Button botontofirst=view.findViewById(R.id.BackButton);
        botontofirst.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_inicioFalso_to_FirstFragment);
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_falso, container, false);
    }
}