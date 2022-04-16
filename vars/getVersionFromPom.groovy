import com.silka.sharedlib.MySharedlibWithUT
def call() {
    def mysharedlib = new MySharedlibWithUT(this) // pass this to the object
    echo "version is :"+mysharedlib.getVersionFromPom()
}