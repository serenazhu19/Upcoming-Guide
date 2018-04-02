# Upcoming-Guide
Application to display upcoming guides

*Serena Zhu*

**Problem:**
Creating an Android application that displays information received over the network:
- Retrieve and print out data
- Parse the data retrieved from the server
- Display the guide information
- Have you view display the guide’s image
The user should be able to open the application and clearly view the upcoming guides, including their names, locations, and end date.

**Solution:**
Created an app that when opened displays a scrollable list populated with information about upcoming events, including their names, locations, and end dates.

**Problems:**
- The GuideAdapter was buggy, thus I have commented out the code for the entire ListView and instead display the information of two events due to the time constraint. This display, however, demonstrates that I correctly retrieved and parsed the data into a list of Java objects that can then be displayed.
- There were no venues provided at the url, thus the venue for all events is displayed as “{}”
- The icons do not currently load

**Technical Choices:**
- Networking: Volley and GSON
I chose to use the GSON library which works with the Volley library for networking purposes because it easily parses through JSON data retrieved from a server. Additionally, Volley is asynchronous, thus that moves the networking off of the UI thread to prevent the app from running slowly. 
- Images: Picasso
Picasso is a library by Square that allows for easy placement of images based on the images’ urls. I chose this library because it quickly takes the image url provided by the server and displays the image. Although its usage in this application requires some debugging.
- Layout: LinearLayout and ListView
I utilized a LinearLayout due to the relative short period of time provided for the application’s creation; I would instead use a more flexible layout choice such as a ConstraintLayout if given more time. I chose a ListView to display the images because I wanted to use a custom adapter to display the guide’s name, city, state, end date, and icon in a single portion of a list. To remain current with Android’s development, I would change this implementation to a RecyclerView with more time.
- Used the standard Android “light” theme because there was not enough time to work directly with the theme of the app and the Android themes tend to look nice.

**Future updates:**
- Resolve the noted problems
- Would implement a ConstraintLayout rather than a LinearLayout
- Would implement a RecyclerView rather than a ListView
- Would utilize Square’s Retrofit library rather than GSON to match the rest of the company’s implementation
- Would not concatenate strings within the setText function
- Would improve the design of the application to be more pleasing to the eye — The current layout is admittedly ugly.

