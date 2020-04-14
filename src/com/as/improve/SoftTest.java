import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Set;

public class SoftTest {

	static class SoftObject {
		byte[] data = new byte[1024];
	}

	public static Set<SoftReference<SoftObject>> cache = new HashSet<>();
	public static int size = 10 * 1024;
	public static ReferenceQueue<SoftObject> referenceQueue = new ReferenceQueue<SoftObject>();
	static int removeReferCount=0;

//	public static void main(String[] args) {
//		for (int i = 0; i < size; i++) {
//			cache.add(new SoftReference<SoftObject>(new SoftObject(), referenceQueue));
//			clearUnlessReference();
//			if (i % 1000== 0) {
//				System.out.println(cache.size()+"----removeReferCount="+removeReferCount);
//			}
//		}
//		System.out.println("End! removeReferCount= "+removeReferCount);
//
//	}

	public static void clearUnlessReference() {
		Reference<? extends SoftObject> ref = referenceQueue.poll();
		while (ref != null) {
			System.out.print("ref");
			if(cache.remove(ref)) {
				removeReferCount++;
			}
			ref = referenceQueue.poll();
		}

	}

}
