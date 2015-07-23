package com.example.felixamoruwa.statisticsapplication.ui;

/**
 * Created by felixamoruwa on 7/15/15.
 */

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.felixamoruwa.statisticsapplication.R;
import com.example.felixamoruwa.statisticsapplication.db.DBUtils;
import com.example.felixamoruwa.statisticsapplication.model.Student;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StudentsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentsFragment extends ListFragment {

    private OnFragmentInteractionListener mListener;
    private ArrayList<Student> students;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StudentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudentsFragment newInstance() {
        StudentsFragment fragment = new StudentsFragment();
        return fragment;
    }

    public StudentsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_students, container, false);

        //Get values from SQLite
        DBUtils dbu = new DBUtils(getActivity());
        students = dbu.selectAllStudentsQuery();

        ArrayList<String> studentsString = new ArrayList<String>();
        studentsString.add("Stud    Q1    Q2    Q3    Q4    Q5");
        for(Student student: students) {
            studentsString.add(student.toStringDisplay());
        }

        String[] studentsArray = studentsString.toArray(new String[studentsString.size()]);

        ArrayAdapter<String> adapter = (new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1, studentsArray));
        setListAdapter(adapter);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
