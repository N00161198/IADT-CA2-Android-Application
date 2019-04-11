package com.mc.ca2.ryanshirley.college;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mc.ca2.ryanshirley.college.model.Enrolment;
import com.mc.ca2.ryanshirley.college.model.Model;
import com.mc.ca2.ryanshirley.college.model.api.AbstractAPIListener;

import java.util.List;


public class EnrolmentsFragment extends Fragment {

    private EnrolmentsAdaptor adaptor;

    public static EnrolmentsFragment newInstance() {
        EnrolmentsFragment fragment = new EnrolmentsFragment();
        return fragment;
    }

    private OnFragmentInteractionListener mListener;

    public EnrolmentsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    // Define that should be displayed on the screen
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enrolments, container, false);
    }

    @Override
    // Populate view with data
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            DividerItemDecoration decoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
            recyclerView.addItemDecoration(decoration);

            Application application = this.getActivity().getApplication();
            Model model = Model.getInstance(application);
            final List<Enrolment> enrolments = model.getEnrolments();

            adaptor = new EnrolmentsAdaptor(this, enrolments);
            recyclerView.setAdapter(adaptor);

            model.loadEnrolments(new AbstractAPIListener(){
                @Override
                public void onEnrolmentsLoaded(List<Enrolment> loadedEnrolments) {
                     enrolments.clear();
                     enrolments.addAll(loadedEnrolments);
                     adaptor.notifyDataSetChanged();
                }
            });
        }
    }

    public void onItemSelected(Enrolment enrolment) {
        if (mListener != null) {
            mListener.onItemSelected (enrolment);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
        else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    // Notify adaptor that data has been changed. (in the event an enrolment was created, updated or deleted)
    public void onResume() {
        super.onResume();
        if (adaptor != null) {
            adaptor.notifyDataSetChanged();
        }
    }

    public interface OnFragmentInteractionListener {
        void onItemSelected(Enrolment enrolment);
    }
}
