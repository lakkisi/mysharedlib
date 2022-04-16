#!/usr/bin/groovy
import com.silka.mysharedlib.MySharedlibWithUT
def call() {
    def mysharedlib = new MySharedlibWithUT(this) // pass this to the object
    echo "version is :"+mysharedlib.getVersionFromPom()
}