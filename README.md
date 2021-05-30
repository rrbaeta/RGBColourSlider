# RGB Colour Slider 

### Design Choices:

The first step when starting to develop the app was to set up a Navigation component, this was not particularly important for this toy app, but it is a recommended design practice because it is very useful to implement navigation bars, buttons, navigation drawers and more, it also enables the creation of smoother navigation experiences.

In order for the design to adapt to phones with different screen sizes a ConstraintLayout was used due to the fact that components are defined relative to other components.

To implement the RGB sliders the SeekBar component was used because it is a simple component to use and gives a good user experience. To read the value of the slider bars a OnSeekBarChangeListener was set up, this listener is triggered when the user interacts with one of the three sliders and was set up to read the slider progress value while the user is interacting with the slider and/or has a finger on the slider, this creates a smooth transition between colours.

Picking up on the previous point, relating to the listener, when the progress value of the slider is read the values are confined to a scale of 0 to 100 and the intended scale to represent a colour level is 0 to 255, to convert from one scale to the other the simple Rule of Three was used, for example if the slide bar is at a progress value of 27 the calculation would be 71*255/100 which would be approximately 181 on a scale of 0 to 255.

The function updateUI was created which its role is to update all the UI components every time a change occurs and/or the listener is triggered, this function enables code reuse, to have a cleaner code, easier to understand and easier to update.


### Instructions:

**Installation:**

Clone this repository and import into Android Studio

```
git clone https://github.com/rrbaeta/RGBColourSlider.git
```

**Run:**

To run the application a phone with Android version 9 or later should be connected to the computer, after the phone is connected running the application on Android Studio will install and launch the application. An emulator can also be used for the same purpose.
