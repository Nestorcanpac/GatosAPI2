package com.example.gatosapi1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.gatosapi1.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Gato> gatos;
    private GatoAdapter gatoAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gatos=new ArrayList<>();

        actualizar();

        gatoAdapter=new GatoAdapter(
                getContext(),
                R.layout.gatos_row,
                gatos
        );

        binding.ListaGatos.setAdapter(gatoAdapter);
        binding.ListaGatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Gato gatoSeleccionado=gatoAdapter.getItem(position);

                Bundle args=new Bundle();
                args.putString("ImagenGato",gatoSeleccionado.getImage());

                Navigation.findNavController(view).navigate(R.id.action_FirstFragment_to_SecondFragment,args);
            }
        });


    }


    void actualizar(){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.myLooper());

        executorService.execute(() ->{
            APIGato apiGato=new APIGato();
            ArrayList<Gato> result=apiGato.getGatos();

            handler.post(() ->{
                gatoAdapter.clear();
                for(Gato g: result){
                    gatoAdapter.add(g);
                }
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}