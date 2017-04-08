#!/bin/bash
filetext=$(cat /home/ubuntu/thefile.txt)
echo $filetext
echo ${filetext:0:1}
echo ${filetext:1:1}
echo ${filetext:2:1}
echo ${filetext:3:1}
if [ ${filetext:0:1} = 1 ] ; then
        myvar="my_gridview"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ ${filetext:1:1} = 1 ] ; then
        myvar="my_linearlayout1"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ ${filetext:2:1} = 1 ] ; then
        myvar="my_linearlayout2"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ ${filetext:3:1} = 1 ] ; then
        myvar="my_linearlayout3"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi