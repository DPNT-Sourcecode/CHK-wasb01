package befaster.solutions.CHK;

import java.util.*;

public class ItemOfferDictionary {

public static TreeMap<Character, ItemOffer> itemOfferMap = new TreeMap<Character, ItemOffer>();
	
	static{
		itemOfferMap.put('A', new ItemOffer('A', 3, 130.0));
		itemOfferMap.put('B', new ItemOffer('B', 2, 45.0));
	}
	
}


