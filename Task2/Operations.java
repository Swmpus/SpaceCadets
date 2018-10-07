private class Operations 
{
	public static void clear(IntObj Pointer) 
	{
		Pointer = new IntObj(0);
	}

	public static void incr(IntObj Pointer, int Value) 
	{
		if (Value == 0) {
			Pointer += 1;
		} else {
			Pointer += Value;
		}
	}

	public static void decr(IntObj Pointer, int Value) 
	{
		if (Value == 0) {
			Pointer -= 1;
		} else {
			Pointer -= Value;
		}
	}

	public static boolean not(IntObj Pointer, int Value) 
	{
		return Pointer != Value;
	}
}