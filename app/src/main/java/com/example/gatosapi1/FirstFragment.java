package com.example.gatosapi1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gatosapi1.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.Inflater;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Gato> gatos;
    private GatoAdapter gatoAdapter;

    private GatosViewModel gatosViewModel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
       View view=binding.getRoot();
       setHasOptionsMenu(true);
        // return binding.getRoot();
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gatos=new ArrayList<>();



        gatoAdapter=new GatoAdapter(
            getContext(),
            R.layout.gatos_row,
            gatos
    );

    gatosViewModel=new ViewModelProvider(this).get(GatosViewModel.class);
    gatosViewModel.getGatos().observe(getViewLifecycleOwner(),gatoes -> {
        gatoAdapter.clear();
        gatoAdapter.addAll(gatoes);
    });


    binding.ListaGatos.setAdapter(gatoAdapter);




        binding.ListaGatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Gato gatoSeleccionado=gatoAdapter.getItem(position);

                Bundle args=new Bundle();
                args.putString("ImagenGato",gatoSeleccionado.getImage());
                args.putInt("GrandariaW",gatoSeleccionado.getWeight());
                args.putInt("GrandariaH",gatoSeleccionado.getHeight());

                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment,args);
            }
        });


    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_main,menu);
    }

    //    @Override
//    public void onCreateOptionsMenu(Menu menu, Inflater inflater) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        inflater.inflate(R.menu.menu_main, menu);
//
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;


        } else if (id== R.id.action_actualizar) {

            actualizar();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    void actualizar(){
        gatosViewModel.reload();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}