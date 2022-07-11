package befaster.solutions.CHK;

import java.util.*;

public class ItemPriceDictionary {

public static TreeMap<Character, Double> itemPriceMap = new TreeMap<Character, Double>();
	
	static{
		itemPriceMap.put(null, 0.0);
		itemPriceMap.put('A', 50.0);
		itemPriceMap.put('B', 30.0);
		itemPriceMap.put('C', 20.0);
		itemPriceMap.put('D', 15.0);
	}
	
}

