package com.pruebas.elsve.recyclerviewenfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecyclerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Dato> datos = createData();
        mAdapter = new RecyclerAdapter(datos);
        mRecyclerView.setAdapter(mAdapter);
        //mAdapter.setData(datos);
        //mAdapter.notifyDataSetChanged();
        return view;
    }

    private List<Dato> createData() {

        List<Dato> datos = new ArrayList<Dato>();
        datos.add(new Dato("uno", "dos"));
        datos.add(new Dato("tres", "cuatro"));
        datos.add(new Dato("cinco", "seis"));
        datos.add(new Dato("siete", "ocho"));
        datos.add(new Dato("nueve", "diez"));
        return datos;

    }

    // TODO: Rename method, update argument and hook method into UI event

    private class DatosHolder extends RecyclerView.ViewHolder {
        private TextView mCadena1, mCadena2;
        private Dato mDato;

        public DatosHolder(View itemView){
            super(itemView);

            mCadena1 = (TextView) itemView.findViewById(R.id.cadena1);
            mCadena2 = (TextView) itemView.findViewById(R.id.cadena2);

        }

        public void bindData(Dato dato){
            mDato = dato;
            mCadena1.setText(dato.getTexto1());
            mCadena2.setText(dato.getTexto2());
        }
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<DatosHolder>{

        private List<Dato> mDatos;

        public RecyclerAdapter(List<Dato> datos){
            mDatos = datos;
        }

        @Override
        public DatosHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_recycler, parent, false);
            return  new DatosHolder(view);
        }

        @Override
        public void onBindViewHolder(DatosHolder holder, int position) {
            Dato dato = mDatos.get(position);
            holder.bindData(dato);
        }

        @Override
        public int getItemCount() {
            return mDatos.size();
        }

        public void setDatos(List<Dato> datos){
            mDatos = datos;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
