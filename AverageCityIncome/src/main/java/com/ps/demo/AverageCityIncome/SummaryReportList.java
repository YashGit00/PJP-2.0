package com.ps.demo.AverageCityIncome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import PerCapitaInformation.PerCapitaInfoDAO;
import PerCapitaSummFormat.SummaryItemDao;

public class SummaryReportList {

	Map<SummaryItemDao, Float> map;
	
	public SummaryReportList() {
		map = new HashMap<SummaryItemDao, Float>();
	}
	
	public SummaryReportList( PerCapitaInfoDAOList DAOList) {
		map = new HashMap<SummaryItemDao, Float>();
		setMap(DAOList);
	}
	private void setMap( PerCapitaInfoDAOList DAOList) {
		List<SummaryItemDao> itemList = new ArrayList<SummaryItemDao>();
		List<Float> avgIncomeList = new ArrayList<Float>();
		List<Integer> countList = new ArrayList<Integer>();
		for (PerCapitaInfoDAO obj : DAOList.getList()) {
			SummaryItemDao item = new SummaryItemDao(obj);
			if ( itemList.contains(item)) {
				int index = itemList.indexOf(item);
				Float amnt = avgIncomeList.get(index);
				int count = countList.get(index);
				Float newAmnt = amnt*count;
				count++;
				newAmnt += obj.getAmntInUSD().getAmountInUSD();
				newAmnt /= count;
				avgIncomeList.set(index, newAmnt);
				countList.set(index, count);
			}
			else {
				itemList.add(item);
				avgIncomeList.add(obj.getAmntInUSD().getAmountInUSD());
				countList.add(1);
			}
		}
		
		int len = avgIncomeList.size();
		for ( int i = 0; i < len; i++) {
			map.put(itemList.get(i), avgIncomeList.get(i));
		}
	}
	public Map<SummaryItemDao, Float> getMap() {
		return map;
	}
}
