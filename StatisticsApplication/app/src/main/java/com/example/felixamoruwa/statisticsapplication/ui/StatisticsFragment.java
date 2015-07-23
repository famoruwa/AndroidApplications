package com.example.felixamoruwa.statisticsapplication.ui;

/**
 * Created by felixamoruwa on 7/15/15.
 */

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.felixamoruwa.statisticsapplication.R;
import com.example.felixamoruwa.statisticsapplication.Utils.StatisticsUtils;
import com.example.felixamoruwa.statisticsapplication.Utils.DBUtils;
import com.example.felixamoruwa.statisticsapplication.model.Student;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatisticsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatisticsFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private ArrayList<Student> students;

    private TextView lblHighScoreQ1;
    private TextView lblHighScoreQ2;
    private TextView lblHighScoreQ3;
    private TextView lblHighScoreQ4;
    private TextView lblHighScoreQ5;

    private TextView lblLowScoreQ1;
    private TextView lblLowScoreQ2;
    private TextView lblLowScoreQ3;
    private TextView lblLowScoreQ4;
    private TextView lblLowScoreQ5;

    private TextView lblAvgScoreQ1;
    private TextView lblAvgScoreQ2;
    private TextView lblAvgScoreQ3;
    private TextView lblAvgScoreQ4;
    private TextView lblAvgScoreQ5;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatisticsFragment newInstance() {
        StatisticsFragment fragment = new StatisticsFragment();
        return fragment;
    }

    public StatisticsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_statistics, container, false);

        lblHighScoreQ1 = (TextView) v.findViewById(R.id.lblHighScoreQ1);
        lblHighScoreQ2 = (TextView) v.findViewById(R.id.lblHighScoreQ2);
        lblHighScoreQ3 = (TextView) v.findViewById(R.id.lblHighScoreQ3);
        lblHighScoreQ4 = (TextView) v.findViewById(R.id.lblHighScoreQ4);
        lblHighScoreQ5 = (TextView) v.findViewById(R.id.lblHighScoreQ5);

        lblLowScoreQ1 = (TextView) v.findViewById(R.id.lblLowScoreQ1);
        lblLowScoreQ2 = (TextView) v.findViewById(R.id.lblLowScoreQ2);
        lblLowScoreQ3 = (TextView) v.findViewById(R.id.lblLowScoreQ3);
        lblLowScoreQ4 = (TextView) v.findViewById(R.id.lblLowScoreQ4);
        lblLowScoreQ5 = (TextView) v.findViewById(R.id.lblLowScoreQ5);

        lblAvgScoreQ1 = (TextView) v.findViewById(R.id.lblAvgScoreQ1);
        lblAvgScoreQ2 = (TextView) v.findViewById(R.id.lblAvgScoreQ2);
        lblAvgScoreQ3 = (TextView) v.findViewById(R.id.lblAvgScoreQ3);
        lblAvgScoreQ4 = (TextView) v.findViewById(R.id.lblAvgScoreQ4);
        lblAvgScoreQ5 = (TextView) v.findViewById(R.id.lblAvgScoreQ5);

        //Get values from SQLite
        DBUtils dbu = new DBUtils(getActivity());
        students = dbu.selectAllStudentsQuery();

        StatisticsUtils stats = new StatisticsUtils();
        stats.generateStatistics(students);
        int[] highScores = stats.getHighScores();
        int[] lowScores = stats.getLowScores();
        double[] avgScores = stats.getAvgScores();

        lblHighScoreQ1.setText("" + highScores[0]);
        lblHighScoreQ2.setText("" + highScores[1]);
        lblHighScoreQ3.setText("" + highScores[2]);
        lblHighScoreQ4.setText("" + highScores[3]);
        lblHighScoreQ5.setText("" + highScores[4]);

        lblLowScoreQ1.setText("" + lowScores[0]);
        lblLowScoreQ2.setText("" + lowScores[1]);
        lblLowScoreQ3.setText("" + lowScores[2]);
        lblLowScoreQ4.setText("" + lowScores[3]);
        lblLowScoreQ5.setText("" + lowScores[4]);

        lblAvgScoreQ1.setText("" + String.format("%.1f", avgScores[0]));
        lblAvgScoreQ2.setText("" + String.format("%.1f", avgScores[1]));
        lblAvgScoreQ3.setText("" + String.format("%.1f", avgScores[2]));
        lblAvgScoreQ4.setText("" + String.format("%.1f", avgScores[3]));
        lblAvgScoreQ5.setText("" + String.format("%.1f", avgScores[4]));

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
