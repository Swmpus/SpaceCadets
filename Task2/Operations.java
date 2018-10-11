private class Operations 
{
	public static void clear(IntObj Pointer) 
	{
		Pointer = 0;
	}

	public static void incr(IntObj Pointer, int Value) 
	{
		Pointer += Value;
	}

	public static void decr(IntObj Pointer, int Value) 
	{
		Pointer -= Value;
	}

	public static boolean not(IntObj Pointer, int Value) 
	{
		return Pointer != Value;
	}
}