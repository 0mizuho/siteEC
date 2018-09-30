package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

public class BuyItemAction extends ActionSupport implements SessionAware{

	public Map<String,Object> session;
	private int count;
	private String pay;

	public String execute(){
		String result=SUCCESS;
		/*total_priceにカウント×金額を入れ込む*/
		session.put("count",count);
		/*intのデータ型を持つ整数を文字型(String）に変換する */
		int intCount=Integer.parseInt(session.get("count").toString());
		int intPrice=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price",intCount*intPrice);

		/*支払い方法の処理をif文で分ける。*/
		String payment;
		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay",payment);
		}else{
			payment="クレジットカード";
			session.put("pay",payment);
		}
		return result;
	}

	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count=count;
	}

	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay=pay;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}
	public Map<String,Object> getSession(){
		return session;
	}

}
