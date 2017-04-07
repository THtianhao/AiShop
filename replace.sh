#!/bin/bash
if [ $TOTOVAR1 = 1 ] ; then     
	myvar="my_gridview"
find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ $TOTOVAR2 = 1 ] ; then   
	myvar="my_linearlayout1"
find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi 
if [ $TOTOVAR3 = 1 ] ; then 
	myvar="my_linearlayout2"
find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ $TOTOVAR4 = 1 ] ; then
        myvar="my_linearlayout3"
find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi

