package com.mc.ca2.ryanshirley.college;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.mc.ca2.ryanshirley.college.model.Enrolment;

/**
 * This class responsible for displaying a list of enrolments
 * while also providing access to view an individual enrolment or create a new one.
 */
 public class EnrolmentsActivity extends AppCompatActivity implements EnrolmentsFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrolments);

        // Create fragment transaction to handle the transactions between different fragments
        FrameLayout container = findViewById(R.id.enrolments_container);
        if(container != null) {
            Fragment fragment = EnrolmentsFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.enrolments_container, fragment);
            fragmentTransaction.commit();
        }

        // Create event listener for creating a new enrolment
        FloatingActionButton button = findViewById(R.id.action_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EnrolmentsActivity.this, EnrolmentActivity.class);
                startActivity(intent);
            }
        });
    }

     @Override
     public void onItemSelected(Enrolment enrolment) {
        // Display the single enrolment that was selected.
        Intent intent = new Intent(this, EnrolmentActivity.class);
        intent.putExtra(EnrolmentFragment.ARG_ENROLMENT_ID, enrolment.getId());
        startActivity(intent);
//         Toast.makeText(this, "Enrolment Selected:  " + enrolment, Toast.LENGTH_LONG).show();
     }
 }
