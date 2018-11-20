# Clock Tutorial
In this tutorial, you will learn how to make a simple app to set an alarm for a given time, and cancel it.

---

# Step 1: Create The UI
First, we need to whip up a simple UI for our app. You should already be familiar with this process from previous projects, but this UI has an element in it that is not in the WYSIWYG editor.

This is what we will be going for:

![UI Screenshot](./img/UI_Screenshot.png)

To create the time setter, we need to add a bit of xml directly to the top of the `activity_main.xml` file:

```xml
    <TimePicker
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:timePickerMode="spinner" />
```
This will place the `TimePicker` and we can now work with it in the WYSIWYG eitor. After getting the `TimePicker` the way you want it, add the buttons and the switch.

We will discuss what these buttons will do in future sections.

---

# Step 2: Setting Alarms With The Android API

Setting alarms from the Android API is actually quite easy. All that is needed is to run an intents with a few parameters. 

The intent needed is called `AlarmClock.ACTION_SET_ALARM`. Running this intent will bring up a system dialogue where the user can set an alarm, but we would like our app to set the alarm itself.  