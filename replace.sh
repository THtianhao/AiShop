#!/bin/bash
echo $filetext
p1= cut -b 1 /home/ubuntu/thefile.txt
p2= cut -b 2 /home/ubuntu/thefile.txt
p3= cut -b 3 /home/ubuntu/thefile.txt
p4= cut -b 4 /home/ubuntu/thefile.txt
echo $p1 $p2 $p3 $p4

if[$p1=1];
    echo '1 success'
    myvar="my_gridview"
    find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
if[$p2=1];
    myvar="my_linearlayout1"
    find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
if[$p3=1];
    myvar="my_linearlayout2"
    find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'
if[$p4=1];
    myvar="my_linearlayout3"
    find ./app/src/ -name 'home_f.xml' | xargs perl -pi -e 's|android:id=\"@\+id\/'$myvar'\"|android:id="@\+id/'$myvar'" android:visibility="gone"|g'