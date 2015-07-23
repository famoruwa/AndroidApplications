package com.example.felixamoruwa.statisticsapplication.ui;

/**
 * Created by felixamoruwa on 7/15/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
//import com.example.felixamoruwa.statisticsapplication.db.DBUtils;

import com.example.felixamoruwa.statisticsapplication.R;
import com.example.felixamoruwa.statisticsapplication.Utils.DBUtils;
import com.example.felixamoruwa.statisticsapplication.model.Student;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddStudentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddStudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddStudentFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private int studentId;
    private int q1;
    private int q2;
    private int q3;
    private int q4;
    private int q5;

    private EditText txtStudentId;
    private EditText txtQ1;
    private EditText txtQ2;
    private EditText txtQ3;
    private EditText txtQ4;
    private EditText txtQ5;
    private Button btnAddStudent;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddStudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddStudentFragment newInstance() {
        AddStudentFragment fragment = new AddStudentFragment();
        return fragment;
    }

    public AddStudentFragment() {
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
        View v = inflater.inflate(R.layout.fragment_add_student, container, false);


        txtStudentId = (EditText) v.findViewById(R.id.txtStudentId);
        txtQ1 = (EditText) v.findViewById(R.id.txtQ1);
        txtQ2 = (EditText) v.findViewById(R.id.txtQ2);
        txtQ3 = (EditText) v.findViewById(R.id.txtQ3);
        txtQ4 = (EditText) v.findViewById(R.id.txtQ4);
        txtQ5 = (EditText) v.findViewById(R.id.txtQ5);

        btnAddStudent = (Button) v.findViewById(R.id.btnSaveStudent);

        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentId = Integer.parseInt(txtStudentId.getText().toString());
                q1 = Integer.parseInt(txtQ1.getText().toString());
                q2 = Integer.parseInt(txtQ2.getText().toString());
                q3 = Integer.parseInt(txtQ3.getText().toString());
                q4 = Integer.parseInt(txtQ4.getText().toString());
                q5 = Integer.parseInt(txtQ5.getText().toString());

                Student student = new Student(studentId, q1, q2, q3, q4, q5);

                //Save values to SQLite
                DBUtils dbu = new DBUtils(getActivity());
                dbu.insertQuery(student);

                Intent resultIntent = new Intent(getActivity(), StatisticsActivity.class);
                startActivity(resultIntent);
            }
        });

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
