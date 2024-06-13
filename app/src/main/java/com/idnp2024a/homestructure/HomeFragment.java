package com.idnp2024a.homestructure;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView imageViewGaleria1 = view.findViewById(R.id.imageViewGaleria1);
        ImageView imageViewGaleria2 = view.findViewById(R.id.imageViewGaleria2);
        ImageView imageViewGaleria3 = view.findViewById(R.id.imageViewGaleria3);
        ImageView imageViewGaleria4 = view.findViewById(R.id.imageViewGaleria4);
        ImageView imageViewGaleria5 = view.findViewById(R.id.imageViewGaleria5);
        ImageView imageViewGaleria6 = view.findViewById(R.id.imageViewGaleria6);
        ImageView imageViewGaleria7 = view.findViewById(R.id.imageViewGaleria7);

        imageViewGaleria1.setOnClickListener(v -> openGalleryFragment(new Gallery1Fragment()));
        imageViewGaleria2.setOnClickListener(v -> openGalleryFragment(new Gallery2Fragment()));
        imageViewGaleria3.setOnClickListener(v -> openGalleryFragment(new Gallery3Fragment()));
        imageViewGaleria4.setOnClickListener(v -> openGalleryFragment(new Gallery4Fragment()));
        imageViewGaleria5.setOnClickListener(v -> openGalleryFragment(new Gallery5Fragment()));
        imageViewGaleria6.setOnClickListener(v -> openGalleryFragment(new Gallery6Fragment()));
        imageViewGaleria7.setOnClickListener(v -> openGalleryFragment(new Gallery7Fragment()));

        return view;
    }

    private void openGalleryFragment(Fragment fragment) {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}