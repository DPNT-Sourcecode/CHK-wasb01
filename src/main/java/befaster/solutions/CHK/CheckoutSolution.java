package befaster.solutions.CHK;

import java.util.*;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

	public TreeMap<String, Integer> skusMap = new TreeMap<String, Integer>();

	public Integer checkout(String skus) {
		try {
			reviewBasket(skus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		addSkusToMap(skus);
		return calculateTotalBasketValue(skusMap);
//		return null;
	}

	public void reviewBasket(String skus) throws Exception {
		if (skus == null || skus.length() == 0) {
			throw new Exception("Basket is empty.");
		}
	}

	public void addSkusToMap(String skus) {
		char[] skusArray = skus.toCharArray();
		for (char c : skusArray) {
			if (skusMap.containsKey(Character.toString(c))) {
				skusMap.put(Character.toString(c), skusMap.get(Character.toString(c)) + 1);
			} else {
				skusMap.put(Character.toString(c), 1);
			}
		}
	}

	public Integer calculateTotalBasketValue(TreeMap<String, Integer> skusMap) {
		Double totalValue = 0.0;
		Set<String> keys = skusMap.keySet();
		for (Iterator<String> i = keys.iterator(); i.hasNext();) {
			String item = i.next();
			Integer quantity = skusMap.get(item);

			if (ItemOfferDictionary.itemOfferMap.containsKey(item)) {
				ItemOffer thisOffer = (ItemOffer) ItemOfferDictionary.itemOfferMap.get(item);

				if (thisOffer.quantity < quantity) {
					totalValue += (quantity % thisOffer.quantity) * ItemPriceDictionary.itemPriceMap.get(item)
							+ (quantity / thisOffer.quantity) * thisOffer.price;
				} else if (thisOffer.quantity == quantity) {
					totalValue += thisOffer.price;
				} else {
					totalValue += (quantity) * ItemPriceDictionary.itemPriceMap.get(item);
				}
			} else {
				totalValue += (quantity) * ItemPriceDictionary.itemPriceMap.get(item);
			}
		}
		return (int) Math.round(totalValue);
	}

}
