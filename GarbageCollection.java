import java.util.*;

class GarbageCollection{
public static void main(String s[]) throws Exception{
Runtime rs = Runtime.getRuntime();
System.out.println("Free memory in JVM(Java Virtual Machine) before garbage collection: "+rs.freeMemory() + "bytes");
rs.gc();
System.out.println("Free memory in JVM (Java Virtual Machine)  after garbage collection: "+rs.freeMemory()+"bytes");
}
}