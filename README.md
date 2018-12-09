<img src="https://github.com/adityasonel/InkPageIndicator/blob/master/app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png" height="200" width="200"/>

# InkPageIndicator
An ink inspired widget for indicating pages in a ViewPager.

## Screenshots

<img src="https://github.com/adityasonel/InkPageIndicator/blob/master/screenshots/inkpage-indicator.mp4" width="200" height="350" />

## How to use

add in your root `build.gradle` :
````
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
````


then add
````
implementation 'com.github.adityasonel:IosTextView:0.2.1'
````
in your app's `build.gradle`

## Usage

First, you need to add `InkPageIndicator` into your XML layout -
```
<com.adityasonel.inkpage_indicator.InkPageIndicator
      android:id="@+id/page_indicator"
      app:dotDiameter="10dp"
      app:dotGap="8dp"
      app:currentPageIndicatorColor="#808080"
      app:pageIndicatorColor="#ffffff" />
```
