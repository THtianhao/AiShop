#!/usr/bin/python
#coding=utf8
"""
import sys
reload(sys)
sys.setdefaultencoding('utf-8')

"""
p1=0
file_object = open('/home/ubuntu/thefile.txt')
try:
	p1 = file_object.read()
finally:
	file_object.close()
if p1[0] == '1':
	print '1success'
	with open('./app/src/main/res/layout/home_f.xml','r+') as f:
		t = f.read()
		t = t.replace("android:id=\"@+id/my_gridview\"", "android:id=\"@+id/my_gridview\" android:visibility=\"gone\"")
		f.seek(0, 0)    
		f.write(t)
		f.close()
if p1[1] == '1':
        print '2success'
        with open('./app/src/main/res/layout/home_f.xml','r+') as f:
                t = f.read()
                t = t.replace("android:id=\"@+id/my_linearlayout1\"", "android:id=\"@+id/my_linearlayout1\" android:visibility=\"gone\"")
                f.seek(0, 0)
                f.write(t)
                f.close()
if p1[2] == '1':
        print '3success'
        with open('./app/src/main/res/layout/home_f.xml','r+') as f:
                t = f.read()
                t = t.replace("android:id=\"@+id/my_linearlayout2\"", "android:id=\"@+id/my_linearlayout2\" android:visibility=\"gone\"")
                f.seek(0, 0)
                f.write(t)
                f.close()
if p1[3] == '1':
        print '4success'
        with open('./app/src/main/res/layout/home_f.xml','r+') as f:
                t = f.read()
                t = t.replace("android:id=\"@+id/my_linearlayout3\"", "android:id=\"@+id/my_linearlayout3\" android:visibility=\"gone\"")
                f.seek(0, 0)
                f.write(t)
                f.close()
