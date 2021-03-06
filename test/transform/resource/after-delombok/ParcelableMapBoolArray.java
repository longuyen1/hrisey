import java.util.Map;

class ParcelableClass implements android.os.Parcelable {
	public static final android.os.Parcelable.Creator<ParcelableClass> CREATOR = new CreatorImpl();
	
	Map<boolean[], boolean[]> myMap;
	
	@java.lang.SuppressWarnings("all")
	public int describeContents() {
		return 0;
	}
	
	@java.lang.SuppressWarnings("all")
	public void writeToParcel(android.os.Parcel dest, int flags) {
		if (this.myMap == null) {
			dest.writeInt(-1);
		} else {
			dest.writeInt(this.myMap.size());
			for (java.util.Map.Entry<boolean[], boolean[]> __loopVar1 : this.myMap.entrySet()) {
				boolean[] __keyVar1 = __loopVar1.getKey();
				boolean[] __valueVar1 = __loopVar1.getValue();
				dest.writeBooleanArray(__keyVar1);
				dest.writeBooleanArray(__valueVar1);
			}
		}
	}
	
	@java.lang.SuppressWarnings("all")
	protected ParcelableClass(android.os.Parcel source) {
		{
			int __sizeVar1 = source.readInt();
			if (__sizeVar1 == -1) {
				this.myMap = null;
			} else {
				this.myMap = new java.util.HashMap<boolean[], boolean[]>();
				while (__sizeVar1 != 0) {
					boolean[] __keyVar1;
					boolean[] __valueVar1;
					__keyVar1 = source.createBooleanArray();
					__valueVar1 = source.createBooleanArray();
					this.myMap.put(__keyVar1, __valueVar1);
					--__sizeVar1;
				}
			}
		}
	}
	
	@java.lang.SuppressWarnings("all")
	private static class CreatorImpl implements android.os.Parcelable.Creator<ParcelableClass> {
		
		@java.lang.SuppressWarnings("all")
		public ParcelableClass createFromParcel(android.os.Parcel source) {
			return new ParcelableClass(source);
		}
		
		@java.lang.SuppressWarnings("all")
		public ParcelableClass[] newArray(int size) {
			return new ParcelableClass[size];
		}
	}
}