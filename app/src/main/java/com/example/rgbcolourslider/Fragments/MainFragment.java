package com.example.rgbcolourslider.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.rgbcolourslider.R;

public class MainFragment extends Fragment {

    //Define all the UI components
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView redTextView;
    private TextView greenTextView;
    private TextView blueTextView;
    private TextView rgbHexTextView;

    //Define the three RGB primary colours
    private int red;
    private int green;
    private int blue;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Initialize all the UI components
        redSeekBar = rootView.findViewById(R.id.redSeekBar);
        greenSeekBar = rootView.findViewById(R.id.greenSeekBar);
        blueSeekBar = rootView.findViewById(R.id.blueSeekBar);
        redTextView = rootView.findViewById(R.id.redTextView);
        greenTextView = rootView.findViewById(R.id.greenTextView);
        blueTextView = rootView.findViewById(R.id.blueTextView);
        rgbHexTextView = rootView.findViewById(R.id.rgbHexTextView);

        //This calls the SeekBar OnChangeListener depending on the SeekBar corresponding to each RGB colour
        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        //This calculates a value in a scale of 0 to 100 to a scale of 0 to 255
        red = redSeekBar.getProgress() * 255 / 100;
        green = greenSeekBar.getProgress() * 255 / 100;
        blue = blueSeekBar.getProgress() * 255 / 100;

        updateUI(red, green, blue);

        return rootView;
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb

            if(seekBar.equals(redSeekBar)){

                red = redSeekBar.getProgress() * 255 / 100;
                updateUI(red, green, blue);

            }
            else if(seekBar.equals(greenSeekBar)){

                green = greenSeekBar.getProgress() * 255 / 100;
                updateUI(red, green, blue);

            }
            else if(seekBar.equals(blueSeekBar)){

                blue = blueSeekBar.getProgress() * 255 / 100;
                updateUI(red, green, blue);

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }
    };

    //This updates all the UI components
    private void updateUI(int red, int green, int blue){

        View rootView = getParentFragment().getView();

        //Display the level of each RGB colour
        blueTextView.setText("Blue: " + blue);
        greenTextView.setText("Green: " + green);
        redTextView.setText("Red: " + red);

        //Transforms the decimal values into hexadecimal values
        String rgbHex = String.format("#%02x%02x%02x", red, green, blue);
        rgbHexTextView.setText("Hexadecimal RGB: " + rgbHex);

        //Change the background colour
        rootView.setBackgroundColor(Color.rgb(red, green, blue));

    }

}