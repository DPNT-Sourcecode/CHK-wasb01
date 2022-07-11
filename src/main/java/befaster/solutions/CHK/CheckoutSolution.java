package befaster.solutions.CHK;

import java.util.*;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

	public TreeMap<Character, Integer> skusMap = new TreeMap<Character, Integer>();

	public Integer checkout(String skus) {
		/*
		 * try { reviewBasket(skus); } catch (Exception e) { e.printStackTrace(); }
		 */
		addSkusToMap(skus);
		return calculateTotalBasketValue(skusMap);
	}

	public void reviewBasket(String skus) throws Exception {
		if (skus == null || skus.length() == 0) {
			throw new Exception("Basket is empty.");
		}
	}

	public void addSkusToMap(String skus) {
		char[] skusArray = skus.toCharArray();
		for (char c : skusArray) {
			if (skusMap.containsKey(c)) {
				skusMap.put(c, skusMap.get(c) + 1);
			} else {
				skusMap.put(c, 1);
			}
		}
	}

	public Integer calculateTotalBasketValue(TreeMap<Character, Integer> skusMap) {
		Double totalValue = 0.0;
		Set<Character> keys = skusMap.keySet();
		for (Iterator<Character> i = keys.iterator(); i.hasNext();) {
			Character item = i.next();
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
				if (ItemPriceDictionary.itemPriceMap.containsKey(item)) {
					totalValue += (quantity) * ItemPriceDictionary.itemPriceMap.get(item);
				}
			}
		}
		return (int) Math.round(totalValue);

	}

}




