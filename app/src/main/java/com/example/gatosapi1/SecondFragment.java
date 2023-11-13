package com.example.gatosapi1;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gatosapi1.databinding.FragmentSecondBinding;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle args2=getArguments();



        binding.NombreGato.setText(creaNombre());
        binding.Atributos.setText(creaAtributos());
        Picasso.get().load(args2.getString("ImagenGato")).into(binding.ImagenGato);
        binding.BackInicio.setOnClickListener(v -> {
            NavController navController= Navigation.findNavController(view);
            navController.navigate(R.id.action_SecondFragment_to_inicioFalso,args2);
        });







    }

    public static String creaNombre(){
        ArrayList<String>nombreGatos=new ArrayList<>();
        nombreGatos.add("Po");
        nombreGatos.add("Rupert");
        nombreGatos.add("Enrique");
        nombreGatos.add("Lala");
        nombreGatos.add("Gorda");
        nombreGatos.add("Gato");
        nombreGatos.add("Eustaquio");
        nombreGatos.add("Oreo");
        nombreGatos.add("Pamela");
        nombreGatos.add("Garfield");
        Random random = new Random();
        int numRan=random.nextInt(11);
        String nomGato= nombreGatos.get(numRan);
        return "Nombre: "+nomGato;
    }

    public static String creaAtributos(){
        ArrayList<String> listaAdjetivos=new ArrayList<>();
        listaAdjetivos.add("Tonto");
        listaAdjetivos.add("Divertido");
        listaAdjetivos.add("Mono");
        listaAdjetivos.add("Gracioso");
        listaAdjetivos.add("Peludo");
        listaAdjetivos.add("Dormilon");
        listaAdjetivos.add("Curioso");
        listaAdjetivos.add("Sigiloso");
        listaAdjetivos.add("Adorable");
        listaAdjetivos.add("Cariñoso");
        listaAdjetivos.add("Elegante");
        Random random = new Random();
        int numRan=random.nextInt(11);
        int numRan2=random.nextInt(11);
        int numRan3=random.nextInt(11);


        return "Atributos: \n" +
                "-"+listaAdjetivos.get(numRan)+"\n" +
                "-"+listaAdjetivos.get(numRan2)+"\n" +
                "-"+listaAdjetivos.get(numRan3);




    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}