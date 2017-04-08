#!/bin/bash
echo $filetext
p1= cut -b 1 /home/ubuntu/thefile.txt
p2= cut -b 2 /home/ubuntu/thefile.txt
p3= cut -b 3 /home/ubuntu/thefile.txt
p4= cut -b 4 /home/ubuntu/thefile.txt
echo $p1 $p2 $p3 $p4

if [ $p1 = 1 ] ; then
		echo 'aaaaa'
        myvar="my_gridview"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ $p2 = 1 ] ; then
        myvar="my_linearlayout1"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ $3
        myvar="my_linearlayout2"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi
if [ $p4 = 1 ] ; then
        myvar="my_linearlayout3"
        find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
fi