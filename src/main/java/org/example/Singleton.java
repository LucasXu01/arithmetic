public class Singleton {

    private Singleton (){}

    public static Singleton getInstance(){
        return singleInstance.sInstance;
    }

    private static class singleInstance{
        private static final Singleton sInstance = new Singleton();
    }
}