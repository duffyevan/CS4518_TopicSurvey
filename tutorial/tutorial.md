# Clock Tutorial
In this tutorial, you will learn how to make a simple app to set an alarm for a given time, and cancel it.

---

# Step 1: Create The UI
First, we need to whip up a simple UI for our app. You should already be familiar with this process from previous projects, but this UI has an element in it that is not in the WYSIWYG editor.

This is what we will be going for:

![UI Screenshot](./img/UI_Screenshot.png)

To create teh time setter, we need to add a bit of xml directly to the `activity_main.xml` file:

```xml
    <TimePicker
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:timePickerMode="spinner" />
```
This will place the `TimePicker` and we can now work with it in the WYSIWYG eitor. After getting the time picker the way you want it, add a button to set the alarm. 

---

# Step 2: Setting Alarms With The Android API
